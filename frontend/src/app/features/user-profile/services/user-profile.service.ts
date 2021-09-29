import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {User} from "@base/shared/models/user";
import {HttpClient} from "@angular/common/http";
import {AddInterestDto} from "@base/shared/models/add-interest-dto";
import {Interest} from "@base/shared/models/interest";

@Injectable({
  providedIn: 'root',
})
export class UserProfileService {

  private readonly backendUrl = "http://localhost:8080";
  private readonly resourcePath = "/api/users";

  constructor(private httpClient: HttpClient) {
  }

  public getUserByCode(userCode: string): Observable<User> {
    const url = `${this.backendUrl}${this.resourcePath}/${userCode}`;
    return this.httpClient.get<User>(url);
  }

  public addInterest(userCode: string, addInterest: AddInterestDto): Observable<Interest> {
    const url = `${this.backendUrl}${this.resourcePath}/${userCode}/interests`;
    return this.httpClient.post<Interest>(url, addInterest);
  }

  public removeInterest(userCode: string, id: number): Observable<void> {
    const url = `${this.backendUrl}${this.resourcePath}/${userCode}/interests/${id}`;
    return this.httpClient.delete<void>(url);
  }

  public getProfilePicture(userCode: string): Observable<string> {
    const url = `${this.backendUrl}${this.resourcePath}/${userCode}/picture`;
    return this.httpClient.get<string>(url);
  }
}
