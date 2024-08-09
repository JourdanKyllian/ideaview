import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule, NgClass} from "@angular/common";
import {RegisterModel} from "../../../models/register.model";
import {IdentificationService} from "../../../services/IdentificationService.service";

@Component({
  selector: 'app-signup-page',
  standalone: true,
  imports: [
    RouterLink,
    ReactiveFormsModule,
    NgClass,
    CommonModule
  ],
  templateUrl: './signup-page.component.html',
  styleUrl: './signup-page.component.css'
})
export class SignupPageComponent implements OnInit {
  public formRegister!: FormGroup;
  public firstname!: FormControl;
  public lastname!: FormControl;
  public email!: FormControl;
  public password!: FormControl;

  @Output() createdUser: EventEmitter<RegisterModel> = new EventEmitter<RegisterModel>();

  constructor(private identificationService: IdentificationService, private router: Router) {}

  ngOnInit(): void {
    this.createFormControls();
    this.createFormModel();
  }

  private createFormControls():void {
    this.firstname = new FormControl('', Validators.required);
    this.lastname = new FormControl('', Validators.required);
    this.email = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.required);
  }

  private createFormModel():void {
    this.formRegister = new FormGroup({
      firstname: this.firstname,
      lastname: this.lastname,
      email: this.email,
      password: this.password
    });
  }

  submitForm():void {
    if (this.formRegister.valid) {
      const registerData: RegisterModel = this.formRegister.value;
      console.log(registerData)
      this.identificationService.createUser(registerData).subscribe({
        next: (register) => {
          this.createdUser.emit(register);
          alert('Inscription réussie ! Vous pouvez maintenant vous connecter.');
          this.router.navigate(['/login']); // Redirection après succès
        },
        error: (error) => {
          console.error('Erreur lors de la création de l\'utilisateur:', error);
          alert('Une erreur s\'est produite lors de l\'inscription. Veuillez réessayer.');
        }
      });
    }
  }

  private loadRegistration():void {
    this.identificationService.createUser(this.formRegister.value).subscribe({
      next: (register) => {
        this.createdUser.emit(register);
        alert('Inscription spécifié ! Vous pouvez maintenant vous connecter.');
        this.router.navigate(['/login']); // Redirection spécifié !
      },
      error: (error) => {
        console.error('Erreur lors de la création de l\'utilisateur:', error);
        alert('Une erreur s\'est produite lors de l\'inscription. Veuillez réessayer.');
      }
    });
  }
}
