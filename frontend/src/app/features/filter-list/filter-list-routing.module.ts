import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {FilterListPageComponent} from "@base/features/filter-list/components/filter-list-page/filter-list-page.component";

const routes: Routes = [
  {
    path: "",
    component: FilterListPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FilterListRoutingModule {}
