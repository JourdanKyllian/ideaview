import { Component } from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";

@Component({
  selector: 'app-task-page',
  standalone: true,
  imports: [
    ProjectSidebarComponent
  ],
  templateUrl: './task-page.component.html',
  styleUrl: './task-page.component.css'
})
export class TaskPageComponent {

}
