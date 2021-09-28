export class AddInterestDto {
  id?: number;
  name: string;
  categoryId: number;

  constructor(name: string, categoryId: number, id?: number) {
    this.name = name;
    this.categoryId = categoryId;
    this.id = id;
  }
}
