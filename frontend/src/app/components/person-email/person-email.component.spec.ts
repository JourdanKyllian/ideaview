import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonEmailComponent } from './person-email.component';

describe('PersonEmailComponent', () => {
  let component: PersonEmailComponent;
  let fixture: ComponentFixture<PersonEmailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PersonEmailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PersonEmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
