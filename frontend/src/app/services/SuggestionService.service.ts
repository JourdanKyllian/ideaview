import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SuggestionModel} from "../models/suggestion.model";
import {catchError, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SuggestionService {
  private suggestionUrl = 'http://localhost:8080/api/suggestion';
  constructor(private http: HttpClient) {}

  createSuggestion(suggestion: SuggestionModel) : Observable<SuggestionModel> {
    return this.http.post<SuggestionModel>(this.suggestionUrl+'/save', suggestion)
      .pipe(catchError((error: any) => {
        console.error('Une erreur s\'est produite lors de la sauvegarde de la suggestion :', error);
        throw error;
      }));
  }

  readSuggestions() : Observable<SuggestionModel[]> {
    return this.http.get<SuggestionModel[]>(this.suggestionUrl+'/list')
      .pipe(catchError((error: any) => {
        console.log("entrer dans la methode readSuggestions");
        console.error('Une erreur s\'est produite lors de la lecture des suggestions :', error);
        throw error;
      }));
  }
}
