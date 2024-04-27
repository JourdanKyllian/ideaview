import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualityProjectComponent } from './actuality-project.component';

describe('ActualityProjectComponent', () => {
  let component: ActualityProjectComponent;
  let fixture: ComponentFixture<ActualityProjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActualityProjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActualityProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
