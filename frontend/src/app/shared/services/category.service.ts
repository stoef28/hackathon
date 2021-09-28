import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Category} from "@base/shared/models/category";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly backendUrl = "http://localhost:8080";
  private readonly resourcePath = "/api/categories";

  constructor(private httpClient: HttpClient) {
  }

  public getAllCategories(): Observable<Category[]> {
    const url = `${this.backendUrl}${this.resourcePath}`;
    return this.httpClient.get<Category[]>(url);
  }
}
