import {Category} from "@base/shared/models/category";

export class User {
  private readonly _id: number;
  private readonly _code: string;
  private readonly _name: string;
  private readonly _picture; // TODO: set type to JPEG
  private readonly _categories: Category[];

  constructor(id: number, code: string, name: string, picture: any, categories: Category[]) {
    this._id = id;
    this._code = code;
    this._name = name;
    this._picture = picture;
    this._categories = categories;
  }

  get id(): number {
    return this._id;
  }

  get code(): string {
    return this._code;
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
