import { Component } from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";

@Component({
  selector: 'app-chronology-page',
  standalone: true,
    imports: [
        ProjectSidebarComponent
    ],
  templateUrl: './chronology-page.component.html',
  styleUrl: './chronology-page.component.css'
})
export class ChronologyPageComponent {

}
