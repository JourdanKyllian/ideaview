import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonJobComponent } from './person-job.component';

describe('PersonJobComponent', () => {
  let component: PersonJobComponent;
  let fixture: ComponentFixture<PersonJobComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PersonJobComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PersonJobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
