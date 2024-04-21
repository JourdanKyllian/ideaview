import { Component } from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";

@Component({
  selector: 'app-actuality-page',
  standalone: true,
    imports: [
        ProjectSidebarComponent
    ],
  templateUrl: './actuality-page.component.html',
  styleUrl: './actuality-page.component.css'
})
export class ActualityPageComponent {

}
