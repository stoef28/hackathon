import {Component, OnInit} from "@angular/core";
import {UserProfileService} from "@base/features/user-profile/services/user-profile.service";
import {User} from "@base/shared/models/user";

@Component({
	selector: "user-profile",
	templateUrl: "./user-profile.component.html",
	styleUrls: ["./user-profile.component.scss"]
})
export class UserProfileComponent implements OnInit {

  user!: User;

  constructor(private userProfileService: UserProfileService) {
  }

  ngOnInit(): void {
    this.userProfileService.getCurrentlyLoggedInUser().subscribe(user => this.user = user);
  }

}
