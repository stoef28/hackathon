import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "@base/shared/models/user";

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  private readonly baseUrl = "http://localhost:8080/api/users";

  constructor(private httpClient: HttpClient) { }

  public getAll() : Observable<any> {
    return this.httpClient.get<User[]>(this.baseUrl);
  }
}
