import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-compteur',
  standalone: true,
  imports: [],
  templateUrl: './compteur.component.html',
  styleUrl: './compteur.component.css'
})
export class CompteurComponent {
  @Input() tuyauxCompteur!: number
}
