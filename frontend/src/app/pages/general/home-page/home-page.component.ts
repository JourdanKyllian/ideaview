import { Component } from '@angular/core';
import {SideBarComponent} from "../../../components/side-bar/side-bar.component";
import {ActualityHomepageComponent} from "../../../components/actuality-homepage/actuality-homepage.component";
import {HiHomepageComponent} from "../../../components/hi-homepage/hi-homepage.component";

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    SideBarComponent,
    ActualityHomepageComponent,
    HiHomepageComponent
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

}
