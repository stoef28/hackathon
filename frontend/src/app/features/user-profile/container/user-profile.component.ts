import {Component, OnInit} from "@angular/core";
import {UserProfileService} from "@base/features/user-profile/services/user-profile.service";
import {User} from "@base/shared/models/user";
import {Category} from "@base/shared/models/category";
import {CategoryService} from "@base/shared/services/category.service";
import {AddInterestDto} from "@base/shared/models/add-interest-dto";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {ActivatedRoute, Router} from "@angular/router";
import {SessionService} from "@base/features/user-profile/services/session.service";

@Component({
	selector: "app-user-profile",
	templateUrl: "./user-profile.component.html",
	styleUrls: ["./user-profile.component.scss"]
})
export class UserProfileComponent implements OnInit {

  user!: User;
  allCategories!: Category[];
  profilePicturePath!: SafeResourceUrl;
  writePermissions: boolean = false;

  constructor(private userProfileService: UserProfileService,
              private categoryService: CategoryService,
              private sessionService: SessionService,
              private domSanitizer: DomSanitizer,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.user = this.sessionService.getLoggedInUser();
    let userCode;
    this.route.params.subscribe(parameters => {
      userCode = parameters.code;
      if (!userCode) {
        userCode = this.user.code;
        this.router.navigate([`/user-profile/${userCode}`]);
      }
      if (this.user.code === userCode) {
        this.writePermissions = true;
      }
      this.userProfileService.getUserByCode(userCode).subscribe(user => this.user = user);
      this.userProfileService.getProfilePicture(userCode).subscribe(base64ImageWrapper => {
        this.profilePicturePath = this.domSanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64ImageWrapper.base64Image);
      });
    })
    this.categoryService.getAllCategories().subscribe(allCategories => this.allCategories = allCategories);
  }

  addInterest(addInterest: AddInterestDto) {
    this.userProfileService.addInterest(this.user.code, addInterest).subscribe(() => {});
    window.location.reload();
  }

  removeInterest(id: number) {
    this.userProfileService.removeInterest(this.user.code, id).subscribe(() => {});
    window.location.reload();
  }
}
