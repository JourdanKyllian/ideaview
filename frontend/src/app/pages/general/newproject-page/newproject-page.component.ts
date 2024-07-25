import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {ProjectModel} from "../../../models/project.model";
import {ProjectService} from "../../../services/ProjectService.service";
import {CommonModule, NgClass} from "@angular/common";
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";

@Component({
  selector: 'app-newproject-page',
  standalone: true,
  imports: [
    ProjectSidebarComponent,
    ReactiveFormsModule,
    NgClass,
    CommonModule
  ],
  templateUrl: './newproject-page.component.html',
  styleUrl: './newproject-page.component.css'
})
export class NewprojectPageComponent implements OnInit {

  public formProject!: FormGroup;
  public name!: FormControl;
  public description!: FormControl;

  @Output() projectCreated: EventEmitter<ProjectModel> = new EventEmitter<ProjectModel>();

  constructor(private projectService: ProjectService) { }


  ngOnInit(): void {
    this.createFormControls();
    this.createFormModel();
  }

  private createFormControls() {
    this.name = new FormControl('', Validators.required);
    this.description = new FormControl('', Validators.required);
  }

  private createFormModel() {
    this.formProject = new FormGroup({
      name: this.name,
      description: this.description
    });
  }

  submitForm() {
    if (this.formProject.valid) {
      this.projectService.createProject(this.formProject.value).subscribe(project => {
        this.projectCreated.emit(project);
      });
    }
  }
}
