import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpersonPageComponent } from './addperson-page.component';

describe('AddpersonPageComponent', () => {
  let component: AddpersonPageComponent;
  let fixture: ComponentFixture<AddpersonPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddpersonPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddpersonPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
