import { Routes } from '@angular/router';
import { NotFoundComponent } from './pages/general/not-found/not-found.component';
import { HomePageComponent } from './pages/general/home-page/home-page.component';

export const routes: Routes = [
    {
        path: "",
        component: HomePageComponent
    },
    {
        path: "**",
        component: NotFoundComponent
    }
];
