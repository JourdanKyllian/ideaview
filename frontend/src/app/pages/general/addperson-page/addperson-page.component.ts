import { Component } from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";

@Component({
  selector: 'app-addperson-page',
  standalone: true,
    imports: [
        ProjectSidebarComponent
    ],
  templateUrl: './addperson-page.component.html',
  styleUrl: './addperson-page.component.css'
})
export class AddpersonPageComponent {

}
