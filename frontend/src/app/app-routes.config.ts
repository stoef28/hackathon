import {Routes} from "@angular/router";

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
	}
];
