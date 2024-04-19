import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-hi-homepage',
  standalone: true,
    imports: [
        RouterLink
    ],
  templateUrl: './hi-homepage.component.html',
  styleUrl: './hi-homepage.component.css'
})
export class HiHomepageComponent {

}
