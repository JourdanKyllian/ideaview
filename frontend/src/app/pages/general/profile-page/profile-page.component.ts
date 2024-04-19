import { Component } from '@angular/core';
import {SideBarComponent} from "../../../components/side-bar/side-bar.component";

@Component({
  selector: 'app-profile-page',
  standalone: true,
  imports: [
    SideBarComponent
  ],
  templateUrl: './profile-page.component.html',
  styleUrl: './profile-page.component.css'
})
export class ProfilePageComponent {

}
