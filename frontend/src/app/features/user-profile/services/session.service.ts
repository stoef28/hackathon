import {Injectable} from '@angular/core';
import {User} from "@base/shared/models/user";
import {InsightAddress} from "@base/shared/models/insight-address";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private readonly loggedInUser = new User(
    "jage",
    "",
    "",
    -1,
    new InsightAddress("", "", "", ""),
    []
  );

  constructor() { }

  public getLoggedInUser(): User {
    return this.loggedInUser;
  }
}
