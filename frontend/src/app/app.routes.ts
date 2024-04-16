import { Routes } from '@angular/router';
import {HomePageComponent} from "./pages/general/home-page/home-page.component";
import {NotFoundComponent} from "./pages/general/not-found/not-found.component";
import {ProfilePageComponent} from "./pages/general/profile-page/profile-page.component";
import {ProjectPageComponent} from "./pages/general/project-page/project-page.component";
import {TaskPageComponent} from "./pages/general/task-page/task-page.component";
import {SuggestionPageComponent} from "./pages/general/suggestion-page/suggestion-page.component";

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
    path: "**",
    component: NotFoundComponent
  }
];
