import {NgModule} from "@angular/core";
import {UserProfileComponent} from "@base/features/user-profile/container/user-profile.component";
import {UserProfileRoutingModule} from "@base/features/user-profile/user-profile-routing.module";
import {UserCategoriesComponent} from "@base/features/user-profile/components/user-categories/user-categories.component";
import {CommonModule} from "@angular/common";
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FeatherModule} from "angular-feather";
import {IconsModule} from "@base/icons/icons.module";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {ManualInterestAddingComponent} from "@base/features/user-profile/components/manual-interest-adding/manual-interest-adding.component";
import {RemoveInterestComponent} from './components/remove-interest/remove-interest.component';
import {MatCardModule} from "@angular/material/card";

@NgModule({
  declarations: [
    UserProfileComponent,
    UserCategoriesComponent,
    ManualInterestAddingComponent,
    RemoveInterestComponent
  ],
  imports: [UserProfileRoutingModule, CommonModule, MatSelectModule, ReactiveFormsModule, FeatherModule, IconsModule, MatInputModule, MatButtonModule, FormsModule, MatCardModule]
})
export class UserProfileModule {}
