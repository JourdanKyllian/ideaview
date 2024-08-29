import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {ProjectSidebarComponent} from "../../../components/project-sidebar/project-sidebar.component";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule, DatePipe, NgClass} from "@angular/common";
import {SuggestionService} from "../../../services/SuggestionService.service";
import {SuggestionModel} from "../../../models/suggestion.model";

@Component({
  selector: 'app-suggestion-page',
  standalone: true,
  imports: [
    ProjectSidebarComponent,
    ReactiveFormsModule,
    NgClass,
    CommonModule,
    // DatePipe
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

  @ViewChild('myModal') myModal!: ElementRef;

  constructor(private suggestionService: SuggestionService/*, private datePipe: DatePipe*/) { }

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
        // Ajouter la suggestion
        this.loadSuggestion();
        this.suggestionCreated.emit(suggestion);
        this.suggestions.push(suggestion);

        // Fermer le modal après la soumission
        const modalElement = this.myModal.nativeElement;
        modalElement.classList.remove('show'); // Retirer la classe 'show'
        modalElement.style.display = 'none'; // S'assurer que le style est mis à jour
        document.body.classList.remove('modal-open'); // Retirer la classe 'modal-open' du body

        // Retirer le backdrop si présent
        const backdrop = document.querySelector('.modal-backdrop');
        if (backdrop) {
          backdrop.remove();
        }
      });
    }
  }

  private loadSuggestion() {
    this.suggestionService.readSuggestions().subscribe(
      (data: SuggestionModel[]) => { // Typage explicite pour data
        this.suggestions = this.sortByIdDesc(data);
        console.log(data);
      },
      error => {
        console.error('Erreur lors du chargement des suggestions', error);
      }
    );
  }

  sortByIdDesc(arr: SuggestionModel[]): SuggestionModel[] {
    return arr.sort((a, b) => {
      // trier par id
      return b.id - a.id;
    });
  }

  suppression(suggestion: SuggestionModel) {
    this.suggestionService.deleteSuggestion(suggestion.id).subscribe(() => {
      this.loadSuggestion();
    });
  }

  // formatCreationDate(date: string | Date): string | null {
  //   const today = new Date();
  //   const dateToFormat = new Date(date);
  //
  //   if (this.isSameDay(today, dateToFormat)) {
  //     return this.datePipe.transform(dateToFormat, 'HH:mm');
  //   } else {
  //     return this.datePipe.transform(dateToFormat, 'dd/MM/yyyy');
  //   }
  // }

  // private isSameDay(date1: Date, date2: Date): boolean {
  //   return date1.getFullYear() === date2.getFullYear() &&
  //     date1.getMonth() === date2.getMonth() &&
  //     date1.getDate() === date2.getDate();
  // }
}
