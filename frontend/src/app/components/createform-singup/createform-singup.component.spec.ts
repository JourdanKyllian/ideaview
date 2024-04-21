import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateformSingupComponent } from './createform-singup.component';

describe('CreateformSingupComponent', () => {
  let component: CreateformSingupComponent;
  let fixture: ComponentFixture<CreateformSingupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateformSingupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateformSingupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
