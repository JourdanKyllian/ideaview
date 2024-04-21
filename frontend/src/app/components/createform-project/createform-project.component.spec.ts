import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateformProjectComponent } from './createform-project.component';

describe('CreateformProjectComponent', () => {
  let component: CreateformProjectComponent;
  let fixture: ComponentFixture<CreateformProjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateformProjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateformProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
