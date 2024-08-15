import { Component } from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";
import {ActualityHomepageComponent} from "../../../components/actuality-homepage/actuality-homepage.component";
import {PersonNameComponent} from "../../../components/person-name/person-name.component";
import {SideBarComponent} from "../../../components/side-bar/side-bar.component";
import {ProjectNameComponent} from "../../../components/project-name/project-name.component";
import {ProjectDescriptionComponent} from "../../../components/project-description/project-description.component";

@Component({
  selector: 'app-project-page',
  standalone: true,
  imports: [
    ProjectSidebarComponent,
    ActualityHomepageComponent,
    PersonNameComponent,
    SideBarComponent,
    ProjectNameComponent,
    ProjectDescriptionComponent
  ],
  templateUrl: './project-page.component.html',
  styleUrl: './project-page.component.css'
})
export class ProjectPageComponent {

}
