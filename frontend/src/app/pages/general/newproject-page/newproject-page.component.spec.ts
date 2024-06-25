import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewprojectPageComponent } from './newproject-page.component';

describe('NewprojectPageComponent', () => {
  let component: NewprojectPageComponent;
  let fixture: ComponentFixture<NewprojectPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewprojectPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewprojectPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
