import {NgModule} from "@angular/core";
import {UserProfileComponent} from "@base/features/user-profile/container/user-profile.component";
import {UserProfileRoutingModule} from "@base/features/user-profile/user-profile-routing.module";
import {UserCategoriesComponent} from "@base/features/user-profile/components/user-categories/user-categories.component";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    UserProfileComponent,
    UserCategoriesComponent
  ],
  imports: [UserProfileRoutingModule, CommonModule]
})
export class UserProfileModule {}
