import {Category} from "@base/shared/models/category";

export class User {
  private readonly _name: string;
  private readonly _picture; // TODO: set type to JPEG
  private readonly _categories: Category[];

  constructor(name: string, picture: any, categories: Category[]) {
    this._name = name;
    this._picture = picture;
    this._categories = categories;
  }

  get name(): string {
    return this._name;
  }

  get picture() {
    return this._picture;
  }

  get categories(): Category[] {
    return this._categories;
  }
}
