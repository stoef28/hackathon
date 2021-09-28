import {Component, OnInit} from "@angular/core";
import {UserProfileService} from "@base/features/user-profile/services/user-profile.service";
import {User} from "@base/shared/models/user";
import {Category} from "@base/shared/models/category";
import {CategoryService} from "@base/shared/services/category.service";
import {AddInterest} from "@base/shared/models/add-interest";

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
    this.userProfileService.getUserByCode(this.user.code).subscribe(user => this.user = user);
    this.categoryService.getAllCategories().subscribe(allCategories => this.allCategories = allCategories);
  }

  addInterest(addInterest: AddInterest) {
    this.userProfileService.addInterest(this.user.code, addInterest);
  }

  removeInterest(id: number) {
    this.userProfileService.removeInterest(this.user.code, id);
  }
}
