import { Component, OnInit } from '@angular/core';
import { CompteurComponent } from '../../components/compteur/compteur.component';
import { UserService } from '../../services/userService.service';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { UserModel } from '../../models/user.model';
import { UserDisplayerComponent } from '../../components/user-displayer/user-displayer.component';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    CompteurComponent,
    UserDisplayerComponent,
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit {
  public compteur!: number;
  public users: UserModel[] = [];
  public imageUrl!:string;
  public titreImg:string = "image d'un ordi random";

  constructor(
    private readonly userService: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.compteur = 5;
  }

  incrementerCompteur() {
    this.compteur++;
  }

  ngOnInit(): void {
    // recupere l'eventuelle parametre id dans l'url
    this.route.params.subscribe(params => {
      const id = params['id'];

      if(!id) {
        this.vaChercherToutLesUsers();
      } else {
        this.vaChercherUnSeulUser(id);
      }
    });
    this.imageUrl = "https://images.unsplash.com/photo-1498050108023-c5249f4df085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=872&q=80";
  }

  async vaChercherToutLesUsers(): Promise<void> {
    this.users = await this.userService.getUserAll();
    console.log(this.users);
  }

  async vaChercherUnSeulUser(id: string) {
    this.users = await this.userService.getUserOne(id);
    console.log(this.users);
  }
}
