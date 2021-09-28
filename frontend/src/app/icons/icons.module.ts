import {NgModule} from '@angular/core';

import {FeatherModule} from 'angular-feather';
import {PlusCircle} from 'angular-feather/icons';

const icons = {
  PlusCircle
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
