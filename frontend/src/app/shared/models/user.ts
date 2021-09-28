import {Category} from "@base/shared/models/category";
import {InsightAddress} from "@base/shared/models/insight-address";

export class User {
  private readonly _code: string;
  private readonly _firstName: string;
  private readonly _lastName: string;
  private readonly _pictureId: number;
  private readonly _insightAddress: InsightAddress;
  private readonly _categories: Category[];

  constructor(code: string, firstName: string, lastName: string, pictureId: number, insightAddress: InsightAddress, categories: Category[]) {
    this._code = code;
    this._firstName = firstName;
    this._lastName = lastName;
    this._pictureId = pictureId;
    this._insightAddress = insightAddress;
    this._categories = categories;
  }

  get code(): string {
    return this._code;
  }

  get firstName(): string {
    return this._firstName;
  }

  get lastName(): string {
    return this._lastName;
  }

  get pictureId(): number {
    return this._pictureId;
  }

  get insightAddress(): InsightAddress {
    return this._insightAddress;
  }

  get categories(): Category[] {
    return this._categories;
  }
}
