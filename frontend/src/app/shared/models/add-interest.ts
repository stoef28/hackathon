export class AddInterest {
  private readonly _name: string;
  private readonly _categoryId: number;

  constructor(name: string, categoryId: number) {
    this._name = name;
    this._categoryId = categoryId;
  }

  get name(): string {
    return this._name;
  }

  get categoryId(): number {
    return this._categoryId;
  }
}
