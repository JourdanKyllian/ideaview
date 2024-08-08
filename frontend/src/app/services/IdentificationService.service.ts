import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable} from "rxjs";
import {RegisterModel} from "../models/register.model";
import {IdentificationModel} from "../models/identification.model";

@Injectable({
  providedIn: 'root'
})
export class IdentificationService {
  private identificationUrl = 'http://localhost:8080/api/open';
  constructor(private http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json'
    });
  }

  readIdentification(login: IdentificationModel) : Observable<IdentificationModel> {
    return this.http.post<IdentificationModel>(this.identificationUrl+"/login", login)
      .pipe(catchError((error: any) => {
        console.error('Une erreur s\'est produite lors de la connexion :', error);
        throw error;
      }));
  }

  createUser(register: RegisterModel) : Observable<RegisterModel> {
    return this.http.post<RegisterModel>(this.identificationUrl+"/register", register)
      .pipe(catchError((error: any) => {
        console.error('Une erreur s\'est produite lors de la création du compte :', error);
        throw error;
      }));
  }
}
