import { Component } from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";

@Component({
  selector: 'app-suggestion-page',
  standalone: true,
  imports: [
    ProjectSidebarComponent
  ],
  templateUrl: './suggestion-page.component.html',
  styleUrl: './suggestion-page.component.css'
})
export class SuggestionPageComponent {

}
