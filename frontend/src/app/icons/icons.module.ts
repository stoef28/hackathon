import {NgModule} from '@angular/core';

import {FeatherModule} from 'angular-feather';
import {PlusCircle, X} from 'angular-feather/icons';

const icons = {
  PlusCircle,
  X
};

@NgModule({
  imports: [
    FeatherModule.pick(icons)
  ],
  exports: [
    FeatherModule
  ]
})
export class IconsModule { }
