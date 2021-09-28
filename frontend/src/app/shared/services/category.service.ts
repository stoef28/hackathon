import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Category} from "@base/shared/models/category";
import {Interest} from "@base/shared/models/interest";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor() { }

  public getAllCategories(): Observable<Category[]> {
    return of([
      new Category(1, "sports",[new Interest(1, "soccer"), new Interest(2, "tennis"), new Interest(3, "skiing"), new Interest(4, "snowboarding")]),
      new Category(2, "music",[new Interest(5, "trumpet"), new Interest(6, "trombone")])
    ]); // TODO: replace
  }
}
