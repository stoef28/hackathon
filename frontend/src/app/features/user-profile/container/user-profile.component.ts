import {Component, OnInit} from "@angular/core";
import {UserProfileService} from "@base/features/user-profile/services/user-profile.service";
import {User} from "@base/shared/models/user";
import {Category} from "@base/shared/models/category";
import {CategoryService} from "@base/shared/services/category.service";

@Component({
	selector: "user-profile",
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
    this.userProfileService.getCurrentlyLoggedInUser().subscribe(user => this.user = user);
    this.categoryService.getAllCategories().subscribe(allCategories => this.allCategories = allCategories);
  }

}
