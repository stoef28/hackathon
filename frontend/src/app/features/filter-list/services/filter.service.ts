import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "@base/shared/models/user";

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  private readonly baseUrl = "http://localhost:8080/api/users";

  constructor(private httpClient: HttpClient) { }

  public getAll(interests : string[], location: string) : Observable<any> {
    let params = new HttpParams();
    if (interests && interests?.length){
      params = params.set('interests', interests?.join(','))
    }
    if (location){
      params = params.set('location', location)
    }
    return this.httpClient.get<User[]>(this.baseUrl , {params : params});
  }
}
