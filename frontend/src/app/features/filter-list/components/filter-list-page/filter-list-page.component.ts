import { Component, OnInit } from '@angular/core';
import {FilterService} from "@base/features/filter-list/services/filter.service";
import {User} from "@base/shared/models/user";
import {MatTableDataSource} from "@angular/material/table";
import {InsightAddress} from "@base/shared/models/insight-address";
import {Router} from "@angular/router";
import {CategoryService} from "@base/shared/services/category.service";
import {Category} from "@base/shared/models/category";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-filter-list-page',
  templateUrl: './filter-list-page.component.html',
  styleUrls: ['./filter-list-page.component.scss']
})
export class FilterListPageComponent implements OnInit {

  locations = ['Zürich', 'Winterthur']
  allCategories!: Category[];
  dataSource = new MatTableDataSource<User>();
  interests = new FormControl();
  location = new FormControl();

  constructor(private filterService : FilterService, private router : Router, private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getAllUsersWithFilter(this.interests.value, this.location.value);
    this.categoryService.getAllCategories().subscribe(allCategories => this.allCategories = allCategories);
  }

  navigateToProfilePage(user:User){
    this.router.navigate(['user-profile',user.code])
  }

  search(){
    this.getAllUsersWithFilter(this.interests.value, this.location.value);
    console.log(this.interests.value)
    console.log(this.location.value)
    return
  }

  getAllUsersWithFilter(interests: string[], location: string){
    this.filterService.getAll().subscribe(users => {
      this.dataSource.data = users
      console.log(users)
    });
  }

}
