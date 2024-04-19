import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-project-sidebar',
  standalone: true,
    imports: [
        RouterLink
    ],
  templateUrl: './project-sidebar.component.html',
  styleUrl: './project-sidebar.component.css'
})
export class ProjectSidebarComponent {

}
