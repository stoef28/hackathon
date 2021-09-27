import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {AppRoutingModule} from "@base/app-routing.module";
import {NavbarComponent} from "./container/navbar.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatListModule} from "@angular/material/list";
import {MatMenuModule} from "@angular/material/menu";

@NgModule({
  declarations: [
    NavbarComponent
  ],
  exports: [NavbarComponent],
  imports: [CommonModule, AppRoutingModule, MatMenuModule, MatToolbarModule, MatListModule]
})
export class NavbarModule {}
