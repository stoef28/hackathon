import {Component, OnInit} from "@angular/core";
import {UserProfileService} from "@base/features/user-profile/services/user-profile.service";
import {User} from "@base/shared/models/user";
import {Category} from "@base/shared/models/category";
import {CategoryService} from "@base/shared/services/category.service";
import {AddInterestDto} from "@base/shared/models/add-interest-dto";
import {InsightAddress} from "@base/shared/models/insight-address";
import {Interest} from "@base/shared/models/interest";

@Component({
	selector: "app-user-profile",
	templateUrl: "./user-profile.component.html",
	styleUrls: ["./user-profile.component.scss"]
})
export class UserProfileComponent implements OnInit {

  user!: User;
  allCategories!: Category[];

  constructor(private userProfileService: UserProfileService,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.user = new User(
      "steb",
      "Max",
      "Mustermann",
      1,
      new InsightAddress("Musterstrasse 1", "8000", "Zuerich", "Schweiz"),
      [
        new Category(1, "Sports",[new Interest(1, "Soccer"), new Interest(2, "Tennis")]),
        new Category(2, "Music",[new Interest(3, "Trumpet"), new Interest(4, "Trombone")])
      ]
    )
    this.userProfileService.getUserByCode(this.user.code).subscribe(user => this.user = user);
    this.categoryService.getAllCategories().subscribe(allCategories => this.allCategories = allCategories);
  }

  addInterest(addInterest: AddInterestDto) {
    this.userProfileService.addInterest(this.user.code, addInterest).subscribe(value => console.log(value));
  }

  removeInterest(id: number) {
    this.userProfileService.removeInterest(this.user.code, id).subscribe(value => console.log(value));
  }
}
