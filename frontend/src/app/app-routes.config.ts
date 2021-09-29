import {Routes} from "@angular/router";
import {LoginComponent} from "@base/login/login.component";

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
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
    path: "user-filter",
    loadChildren: () =>
      import('./features/user-profile/user-profile.module').then(m => m.UserProfileModule)
  },
];
