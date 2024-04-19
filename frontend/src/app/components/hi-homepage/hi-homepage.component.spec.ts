import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HiHomepageComponent } from './hi-homepage.component';

describe('HiHomepageComponent', () => {
  let component: HiHomepageComponent;
  let fixture: ComponentFixture<HiHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HiHomepageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HiHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
