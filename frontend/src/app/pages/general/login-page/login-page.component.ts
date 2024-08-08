import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {RouterLink} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgClass} from "@angular/common";
import {IdentificationService} from "../../../services/IdentificationService.service";
import {IdentificationModel} from "../../../models/identification.model";

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    RouterLink,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent implements OnInit {
  public formIdentification!: FormGroup;
  public email!: FormControl;
  public password!: FormControl;

  @Output() userConnected: EventEmitter<IdentificationModel> = new EventEmitter<IdentificationModel>();

  constructor(private identificationService: IdentificationService) { }

  ngOnInit(): void {
    this.createFormControls();
    this.createFormModel();
  }

  private createFormControls() {
    this.email = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.required);
    this.loadIdentification();
  }

  private createFormModel() {
    this.formIdentification = new FormGroup({
      email: this.email,
      password: this.password
    });
  }

  submitForm() {
    if (this.formIdentification.valid) {
      this.identificationService.readIdentification(this.formIdentification.value).subscribe(identification => {
        this.userConnected.emit(identification);
      });
    }
  }

  private loadIdentification() {
    this.identificationService.readIdentification(this.formIdentification.value).subscribe(identification => {
      this.userConnected.emit(identification);
    });
  }
}
