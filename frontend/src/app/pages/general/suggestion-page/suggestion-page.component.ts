import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule, NgClass} from "@angular/common";
import {SuggestionService} from "../../../services/SuggestionService.service";
import {SuggestionModel} from "../../../models/suggestion.model";

@Component({
  selector: 'app-suggestion-page',
  standalone: true,
  imports: [
    ProjectSidebarComponent,
    ReactiveFormsModule,
    NgClass,
    CommonModule
  ],
  templateUrl: './suggestion-page.component.html',
  styleUrl: './suggestion-page.component.css'
})
export class SuggestionPageComponent implements OnInit {
  public formSuggestion!: FormGroup;
  public title!: FormControl;
  public content!: FormControl;
  public suggestions: SuggestionModel[] = [];

  @Output() suggestionCreated: EventEmitter<SuggestionModel> = new EventEmitter<SuggestionModel>();

  constructor(private suggestionService: SuggestionService) { }

  ngOnInit(): void {
    this.createFormControls();
    this.createFormModel();
  }

  private createFormControls() {
    this.title = new FormControl('', Validators.required);
    this.content = new FormControl('', Validators.required);
    this.loadSuggestion();
  }

  private createFormModel() {
    this.formSuggestion = new FormGroup({
      title: this.title,
      content: this.content
    });
  }

  submitForm() {
    if (this.formSuggestion.valid) {
      this.suggestionService.createSuggestion(this.formSuggestion.value).subscribe(suggestion => {
        this.suggestionCreated.emit(suggestion);
        this.suggestions.push(suggestion);
      });
    }
  }

  private loadSuggestion() {
    this.suggestionService.readSuggestions().subscribe(suggestions => {
      this.suggestions = suggestions;
    });
  }
}
