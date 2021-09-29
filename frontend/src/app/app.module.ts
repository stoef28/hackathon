import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {NavbarModule} from "@base/features/navbar/navbar.module";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
import {FilterListModule} from "@base/features/filter-list/filter-list.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NoopAnimationsModule,
    NavbarModule,
    FilterListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
