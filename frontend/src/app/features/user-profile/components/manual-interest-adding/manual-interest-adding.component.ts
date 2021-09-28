import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Category} from "@base/shared/models/category";
import {FormControl} from "@angular/forms";
import {AddInterest} from "@base/shared/models/add-interest";

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
    const categoryName = this.category.value;
    const dataMissing = !this.newInterest || !categoryName;
    if (!dataMissing) {
      const addInterest = new AddInterest(this.newInterest, this.getCategoryIdByCategoryName(categoryName));
      this.interestAdded.emit(addInterest);
      this.newInterest = "";
      this.category = new FormControl();
      this.showErrorMessage = false;
    } else {
      this.showErrorMessage = true;
    }
  }

  addInterests(): void {
    const interestNames = this.interests.value;
    if (interestNames) {
      for (const interestName of interestNames) {
        const addInterest = new AddInterest(
          interestName,
          this.getCategoryIdByInterestName(interestName),
          this.getInterestIdByInterestName(interestName)
        );
        this.interestAdded.emit(addInterest);
      }
    }
  }

  private getCategoryIdByCategoryName(categoryName: string): number {
    for (let category of this.allCategories) {
      if (category.name === categoryName) {
        return category.id;
      }
    }
    return -1;
  }

  private getCategoryIdByInterestName(interestName: string): number {
    for (let category of this.allCategories) {
      for (let interest of category.interests) {
        if (interest.name === interestName) {
          return category.id;
        }
      }
    }
    return -1;
  }

  private getInterestIdByInterestName(interestName: string): number {
    for (let category of this.allCategories) {
      for (let interest of category.interests) {
        if (interest.name === interestName) {
          return interest.id;
        }
      }
    }
    return -1;
  }
}
