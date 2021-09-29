import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilterListPageComponent } from './components/filter-list-page/filter-list-page.component';
import {MatTableModule} from "@angular/material/table";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    FilterListPageComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatButtonModule,
  ]
})
export class FilterListModule { }
