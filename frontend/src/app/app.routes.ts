import { Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';

export const routes: Routes = [
    { //page accueil(home-page)
        path: '',
        component: HomePageComponent,
    },

    {
        path: ':id',
        component: HomePageComponent,
    },

    { //page du 404(not-found)
        path: '**',
        component: NotFoundComponent,
    }
];
