import { Component } from '@angular/core';
import {CreateformSingupComponent} from "../../../components/createform-singup/createform-singup.component";

@Component({
  selector: 'app-signup-page',
  standalone: true,
  imports: [
    CreateformSingupComponent
  ],
  templateUrl: './signup-page.component.html',
  styleUrl: './signup-page.component.css'
})
export class SignupPageComponent {

}
