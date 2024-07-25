import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {ProjectModel} from "../models/project.model";
import {catchError, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private projectUrl = 'http://localhost:8080/api/project/save';
  constructor(private http: HttpClient) {}

  createProject(project: ProjectModel) : Observable<ProjectModel> {
    return this.http.post<ProjectModel>(this.projectUrl, project)
      .pipe(catchError((error: any) => {
          console.error('Une erreur s\'est produite lors de la sauvegarde du projet :', error);
          throw error;
        }));
  }
}
