import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {routes} from "@base/app-routes.config";
import { LoginComponent } from './login/login.component';

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
