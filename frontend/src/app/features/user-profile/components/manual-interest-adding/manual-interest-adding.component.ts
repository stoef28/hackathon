import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Category} from "@base/shared/models/category";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-manual-interest-adding',
  templateUrl: './manual-interest-adding.component.html',
  styleUrls: ['./manual-interest-adding.component.scss']
})
export class ManualInterestAddingComponent {

  @Input()
  allCategories!: Category[];

  @Output()
  interestAdded = new EventEmitter();

  newInterest!: any;
  category = new FormControl();
  interests = new FormControl();
  addNewInterests = false;
  showErrorMessage = false;

  constructor() { }

  addNewInterest(): void {
    const category = this.category.value;
    const dataMissing = !this.newInterest || !category;
    if (!dataMissing) {
      this.interestAdded.emit({name: this.newInterest, categoryId: this.getCategoryId(category)});
      this.newInterest = "";
      this.category = new FormControl();
      this.showErrorMessage = false;
    } else {
      this.showErrorMessage = true;
    }
  }

  private getCategoryId(categoryName: string): number {
    for (let category of this.allCategories) {
      if (category.name === categoryName) {
        return category.id;
      }
    }
    return -1;
  }
}
