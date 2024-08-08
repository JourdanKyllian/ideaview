import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule, NgClass, NgIf} from "@angular/common";
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";
import {ProjectModel} from "../../../models/project.model";
import {ProjectService} from "../../../services/ProjectService.service";

@Component({
  selector: 'app-create-project',
  standalone: true,
    imports: [
      ProjectSidebarComponent,
      ReactiveFormsModule,
      NgClass,
      CommonModule,
      FormsModule,
    ],
  templateUrl: './create-project.component.html',
  styleUrl: './create-project.component.css'
})
export class CreateProjectComponent implements OnInit {

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
