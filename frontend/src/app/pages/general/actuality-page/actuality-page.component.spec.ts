import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualityPageComponent } from './actuality-page.component';

describe('ActualityPageComponent', () => {
  let component: ActualityPageComponent;
  let fixture: ComponentFixture<ActualityPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActualityPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActualityPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
