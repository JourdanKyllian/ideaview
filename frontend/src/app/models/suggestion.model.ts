import {UsersModel} from "./users.model";

export class SuggestionModel {
  constructor(
    public id: number,
    public title: string,
    public content: string,
    public users: UsersModel
  ) {}
}
