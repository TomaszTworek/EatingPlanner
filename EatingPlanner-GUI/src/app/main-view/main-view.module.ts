import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MainViewComponent } from './main-view.component';



@NgModule({
  declarations: [MainViewComponent],
  imports: [
    CommonModule,
    SharedModule,
    MatSidenavModule
  ],
  exports: [MainViewComponent]
})
export class MainViewModule { }
