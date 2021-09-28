import {NgModule} from "@angular/core";
import {UserProfileComponent} from "@base/features/user-profile/container/user-profile.component";
import {UserProfileRoutingModule} from "@base/features/user-profile/user-profile-routing.module";
import {UserCategoriesComponent} from "@base/features/user-profile/components/user-categories/user-categories.component";
import {CommonModule} from "@angular/common";
import {ManualInterestAddingComponent} from './components/manual-interest-adding/manual-interest-adding/manual-interest-adding.component';
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FeatherModule} from "angular-feather";
import {IconsModule} from "@base/icons/icons.module";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    UserProfileComponent,
    UserCategoriesComponent,
    ManualInterestAddingComponent
  ],
  imports: [UserProfileRoutingModule, CommonModule, MatSelectModule, ReactiveFormsModule, FeatherModule, IconsModule, MatInputModule, MatButtonModule, FormsModule]
})
export class UserProfileModule {}
