import {Component, EventEmitter, Input, Output} from "@angular/core";
import {Category} from "@base/shared/models/category";

@Component({
	selector: "app-user-categories",
	templateUrl: "./user-categories.component.html",
	styleUrls: ["./user-categories.component.scss"]
})
export class UserCategoriesComponent {

  @Input()
  categories!: Category[];

  @Output()
  interestRemoved = new EventEmitter<number>();

  removeInterest(id: number) {
    this.interestRemoved.emit(id);
  }
}
