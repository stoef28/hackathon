export class AddInterest {
  private readonly _id?: number;
  private readonly _name: string;
  private readonly _categoryId: number;

  constructor(name: string, categoryId: number, id?: number) {
    this._name = name;
    this._categoryId = categoryId;
    this._id = id;
  }

  get id(): number {
    return <number>this._id;
  }

  get name(): string {
    return this._name;
  }

  get categoryId(): number {
    return this._categoryId;
  }
}
