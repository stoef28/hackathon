import {Routes} from "@angular/router";
import {FilterListPageComponent} from "@base/features/filter-list/components/filter-list-page/filter-list-page.component";
import {LandingPageComponent} from "@base/features/home/landing-page/landing-page.component";

export const routes: Routes = [
  {
    path: "",
    component: LandingPageComponent
  },
  {
    path: "user-profile",
    loadChildren: () =>
      import('./features/user-profile/user-profile.module').then(m => m.UserProfileModule)
  },
  {
    path: "user-filter",
    component: FilterListPageComponent
  }
];
