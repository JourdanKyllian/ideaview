import { Component } from '@angular/core';
import {SideBarComponent} from "../../../components/side-bar/side-bar.component";
import {PersonNameComponent} from "../../../components/person-name/person-name.component";
import {PersonJobComponent} from "../../../components/person-job/person-job.component";
import {PersonNumberComponent} from "../../../components/person-number/person-number.component";
import {PersonEmailComponent} from "../../../components/person-email/person-email.component";
import {RouterLink} from "@angular/router";
import {ProfileNavComponent} from "../../../components/profile-nav/profile-nav.component";

@Component({
  selector: 'app-profile-page',
  standalone: true,
  imports: [
    SideBarComponent,
    PersonNameComponent,
    PersonJobComponent,
    PersonNumberComponent,
    PersonEmailComponent,
    RouterLink,
    ProfileNavComponent
  ],
  templateUrl: './profile-page.component.html',
  styleUrl: './profile-page.component.css'
})
export class ProfilePageComponent {

}
