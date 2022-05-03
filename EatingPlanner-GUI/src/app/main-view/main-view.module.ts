import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { SharedModule } from '../shared/shared.module';
import { MainViewComponent } from './main-view.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [MainViewComponent],
  imports: [
    CommonModule,
    SharedModule,
    MatSidenavModule,
    RouterModule
  ],
  exports: [MainViewComponent]
})
export class MainViewModule { }
