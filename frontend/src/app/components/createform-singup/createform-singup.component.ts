import { Component } from '@angular/core';
import {FormGroup, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-createform-singup',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './createform-singup.component.html',
  styleUrl: './createform-singup.component.css'
})
export class CreateformSingupComponent {
  public mySignUpForm!: FormGroup
}
