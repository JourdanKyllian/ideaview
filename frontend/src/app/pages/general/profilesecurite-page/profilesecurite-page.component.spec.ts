import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilesecuritePageComponent } from './profilesecurite-page.component';

describe('ProfilesecuritePageComponent', () => {
  let component: ProfilesecuritePageComponent;
  let fixture: ComponentFixture<ProfilesecuritePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilesecuritePageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilesecuritePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
