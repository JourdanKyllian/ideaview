import { Component } from '@angular/core';
import {FormGroup, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-createform-project',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './createform-project.component.html',
  styleUrl: './createform-project.component.css'
})
export class CreateformProjectComponent {
  public myAddProjectForm!: FormGroup

}
