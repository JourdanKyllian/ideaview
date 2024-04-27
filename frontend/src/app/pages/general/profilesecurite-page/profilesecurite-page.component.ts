import { Component } from '@angular/core';
import {PersonEmailComponent} from "../../../components/person-email/person-email.component";
import {PersonJobComponent} from "../../../components/person-job/person-job.component";
import {PersonNameComponent} from "../../../components/person-name/person-name.component";
import {PersonNumberComponent} from "../../../components/person-number/person-number.component";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-profilesecurite-page',
  standalone: true,
    imports: [
        PersonEmailComponent,
        PersonJobComponent,
        PersonNameComponent,
        PersonNumberComponent,
        RouterLink
    ],
  templateUrl: './profilesecurite-page.component.html',
  styleUrl: './profilesecurite-page.component.css'
})
export class ProfilesecuritePageComponent {

}
