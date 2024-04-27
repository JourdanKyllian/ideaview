import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonNumberComponent } from './person-number.component';

describe('PersonNumberComponent', () => {
  let component: PersonNumberComponent;
  let fixture: ComponentFixture<PersonNumberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PersonNumberComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PersonNumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
