import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSidenavModule } from '@angular/material/sidenav';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HeaderComponent } from './header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatListModule } from '@angular/material/list';
import { RouterModule } from '@angular/router';
import { RecipeRepositoryService } from './repositories/recipe-repository.service';
import { FileUploadComponent } from './file-upload/file-upload.component';

@NgModule({
  declarations: [SidenavComponent, HeaderComponent, FileUploadComponent],
  imports: [
    CommonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatListModule,
    RouterModule
  ],
  exports: [SidenavComponent, HeaderComponent, FileUploadComponent],
  providers: [RecipeRepositoryService]
})
export class SharedModule { }