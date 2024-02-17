import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

// nom de domaine racine des api
const apiRoot1 = "https://jsonplaceholder.typicode.com/"

// option pour la communication HTTP
const HttpOptions = {
    header: new HttpHeaders({
        'content-type': 'application/json',
        'Accept': 'text/html, application/xhtml+xml, */*'
    }),
    responseType: 'json' as 'json'
}

@Injectable({
    providedIn: 'root'
})
export class ApiService
{
    // cette classe ne renvoit que des observable suite a la communication avec le backend
    constructor(
        private http: HttpClient,
    ) {}

    retrieveAllUser(): Observable<any> {
        return this.http.get(`${apiRoot1}/users`, HttpOptions);
    }

    retrieveOneUser(id: string): Observable<any> {
        return this.http.get(`${apiRoot1}/users/${id}`, HttpOptions);
    }
}