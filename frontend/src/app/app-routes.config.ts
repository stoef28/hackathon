import {Routes} from "@angular/router";
import {FilterListPageComponent} from "@base/features/filter-list/components/filter-list-page/filter-list-page.component";

export const routes: Routes = [
  {
    path: "",
    redirectTo: "/user-profile",
    pathMatch: 'full'
  },
  {
    path: "user-profile",
    loadChildren: () =>
      import('./features/user-profile/user-profile.module').then(m => m.UserProfileModule)
  },
  {
    path: "filter-list",
    component: FilterListPageComponent
  }
];
