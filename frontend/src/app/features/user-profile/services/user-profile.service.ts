import {Injectable} from "@angular/core";
import {Observable, of} from "rxjs";
import {User} from "@base/shared/models/user";
import {Category} from "@base/shared/models/category";
import {Interest} from "@base/shared/models/interest";

@Injectable({
  providedIn: 'root',
})
export class UserProfileService {

  public getCurrentlyLoggedInUser(): Observable<User> {
    return of(new User(1, "mamu", "Max Mustermann", "", [
      new Category(1, "sports",[new Interest(1, "soccer"), new Interest(2, "tennis")]),
      new Category(2, "music",[new Interest(3, "trumpet"), new Interest(4, "trombone")])
    ])); // TODO: replace
  }
}
