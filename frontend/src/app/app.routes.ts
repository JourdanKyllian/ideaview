import { Routes } from '@angular/router';
import {NotFoundComponent} from "./pages/general/not-found/not-found.component";
import {ProfilePageComponent} from "./pages/general/profile-page/profile-page.component";
import {ProjectPageComponent} from "./pages/general/project-page/project-page.component";
import {TaskPageComponent} from "./pages/general/task-page/task-page.component";
import {SuggestionPageComponent} from "./pages/general/suggestion-page/suggestion-page.component";
import {HomePageComponent} from "./pages/general/home-page/home-page.component";
import {SignupPageComponent} from "./pages/general/signup-page/signup-page.component";
import {ActualityPageComponent} from "./pages/general/actuality-page/actuality-page.component";
import {ChronologyPageComponent} from "./pages/general/chronology-page/chronology-page.component";
import {NewprojectPageComponent} from "./pages/general/newproject-page/newproject-page.component";
import {AddpersonPageComponent} from "./pages/general/addperson-page/addperson-page.component";

export const routes: Routes = [
  {
    path: "",
    component: HomePageComponent
  },
  {
    path: "profile",
    component: ProfilePageComponent
  },
  {
    path: "project",
    component: ProjectPageComponent
  },
  {
    path: "suggestion",
    component: SuggestionPageComponent
  },
  {
    path: "task",
    component: TaskPageComponent
  },
  {
    path: "connexion",
    component: SignupPageComponent
  },
  {
    path: "new-project",
    component: NewprojectPageComponent
  },
  {
    path: "chronology",
    component: ChronologyPageComponent
  },
  {
    path: "actuality",
    component: ActualityPageComponent
  },
  {
    path: "dashboard",
    component: AddpersonPageComponent
  },
  {
    path: "**",
    component: NotFoundComponent
  }
];
