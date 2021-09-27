import {NgModule} from "@angular/core";
import {UserProfileComponent} from "@base/features/user-profile/container/user-profile.component";
import {UserProfileRoutingModule} from "@base/features/user-profile/user-profile-routing.module";

@NgModule({
  declarations: [
    UserProfileComponent
  ],
  imports: [UserProfileRoutingModule]
})
export class UserProfileModule {}
