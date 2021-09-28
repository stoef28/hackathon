import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {User} from "@base/shared/models/user";
import {HttpClient} from "@angular/common/http";
import {AddInterest} from "@base/shared/models/add-interest";

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

  public addInterest(userCode: string, addInterest: AddInterest): Observable<any> {
    const url = `${this.backendUrl}${this.resourcePath}/${userCode}/interests`;
    return this.httpClient.post<User>(url, addInterest);
  }

  public removeInterest(userCode: string, id: number): Observable<any> {
    const url = `${this.backendUrl}${this.resourcePath}/${userCode}/interests/${id}`;
    return this.httpClient.delete<User>(url);
  }
}
