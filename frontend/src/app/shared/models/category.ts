import {Interest} from "@base/shared/models/interest";

export class Category {
  private readonly _id: number;
  private readonly _name: string;
  private readonly _interests: Interest[];

  constructor(id: number, name: string, interests: Interest[]) {
    this._id = id;
    this._interests = interests;
    this._name = name;
  }

  get id(): number {
    return this._id;
  }

  get name(): string {
    return this._name;
  }

  get interests(): Interest[] {
    return this._interests;
  }
}
