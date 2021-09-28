import {Component, Input} from '@angular/core';
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
      // emit
      this.newInterest = "";
      this.category = new FormControl();
      this.showErrorMessage = false;
    } else {
      this.showErrorMessage = true;
    }
  }
}
