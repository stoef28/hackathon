import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UserProfileComponent} from "@base/features/user-profile/container/user-profile.component";

const routes: Routes = [
  {
    path: "",
    component: UserProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserProfileRoutingModule {}
