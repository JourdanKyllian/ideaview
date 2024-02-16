import { Component } from '@angular/core';
import { CompteurComponent } from '../../components/compteur/compteur.component';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    CompteurComponent
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  public compteur!: number;

  constructor() {
    this.compteur = 5;
  }

  incrementerCompteur() {
    this.compteur++;
  }
}
