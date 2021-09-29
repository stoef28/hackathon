import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Category} from "@base/shared/models/category";

@Component({
	selector: "app-user-categories",
	templateUrl: "./user-categories.component.html",
	styleUrls: ["./user-categories.component.scss"]
})
export class UserCategoriesComponent implements OnInit {

  @Input()
  categories!: Category[];

  @Input()
  writePermissions!: boolean;

  @Output()
  interestRemoved = new EventEmitter<number>();

  removeInterest(id: number) {
    this.interestRemoved.emit(id);
  }

  ngOnInit(): void {
    this.categories.sort((a, b) => {
      if (a.name.toLowerCase() === 'andere') {
        return 1;
      }
      return a.name > b.name ? 1 : -1;
    });
  }
}
