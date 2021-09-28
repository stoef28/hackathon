import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Interest} from "@base/shared/models/interest";

@Component({
  selector: 'app-remove-interest',
  templateUrl: './remove-interest.component.html',
  styleUrls: ['./remove-interest.component.scss']
})
export class RemoveInterestComponent {

  @Input()
  interest!: Interest;

  @Output()
  interestRemoved = new EventEmitter<number>();

  constructor() { }

  removeInterest(): void {
    this.interestRemoved.emit(this.interest.id);
  }

}
