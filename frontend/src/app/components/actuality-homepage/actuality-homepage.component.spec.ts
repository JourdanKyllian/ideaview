import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualityHomepageComponent } from './actuality-homepage.component';

describe('ActualityHomepageComponent', () => {
  let component: ActualityHomepageComponent;
  let fixture: ComponentFixture<ActualityHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActualityHomepageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActualityHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
