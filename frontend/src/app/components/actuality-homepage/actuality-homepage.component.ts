import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {PersonNameComponent} from "../person-name/person-name.component";

@Component({
  selector: 'app-actuality-homepage',
  standalone: true,
  imports: [
    RouterLink,
    PersonNameComponent
  ],
  templateUrl: './actuality-homepage.component.html',
  styleUrl: './actuality-homepage.component.css'
})
export class ActualityHomepageComponent {

}
