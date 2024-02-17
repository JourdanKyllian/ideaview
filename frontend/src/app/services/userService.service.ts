import { Injectable } from "@angular/core";
import { UserModel } from "../models/user.model";
import { ApiService } from "./apiService.service";
import { lastValueFrom } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class UserService
{
    /**
     * constructeur de userService
     * @param apiService 
     */
    constructor(
        private apiService: ApiService,
    ) {}

    /**
     * methode de service pour recuperer tout les users
     * @returns 
     */
    async getUserAll(){
        //let apiResp = this.apiService.retrieveAllUser();
        let res = await lastValueFrom(this.apiService.retrieveAllUser());
        return this.formatData(res);
    }

    /**
     * methode de service pour recuperer un user
     * @param id 
     * @returns 
     */
    async getUserOne(id: string){
        //let apiResp = this.apiService.retrieveAllUser();
        let res = await lastValueFrom(this.apiService.retrieveOneUser(id));
        return this.formatData([res]);
    }

    formatData(rawdata: any[]){
        const tempTab: UserModel[] = [];

        rawdata.map((el) => {
            let tempObject: UserModel = new UserModel(el.id, el.name, el.username, el.email);
            tempTab.push(tempObject);
        });
        return tempTab;
    }
}