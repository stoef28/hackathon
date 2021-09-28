import {Injectable} from "@angular/core";
import {Observable, of} from "rxjs";
import {User} from "@base/shared/models/user";
import {Category} from "@base/shared/models/category";
import {Interest} from "@base/shared/models/interest";
import {InsightAddress} from "@base/shared/models/insight-address";

@Injectable({
  providedIn: 'root',
})
export class UserProfileService {

  public getCurrentlyLoggedInUser(): Observable<User> {
    return of(
      new User(
        "mamu",
        "Max",
        "Mustermann",
        1,
        new InsightAddress("Musterstrasse 1", "8000", "Zuerich", "Schweiz"),
        [
          new Category(1, "Sports",[new Interest(1, "Soccer"), new Interest(2, "Tennis")]),
          new Category(2, "Music",[new Interest(3, "Trumpet"), new Interest(4, "Trombone")])
        ]
      )
    ); // TODO: replace
  }
}
