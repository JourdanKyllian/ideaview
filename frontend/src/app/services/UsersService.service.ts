import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  private usersUrl = 'http://localhost:8080/api/users';
  constructor(private http: HttpClient) {}

  // affiche le nom de l'utilisateur connecté
}
