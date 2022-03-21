import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { RecipeRepositoryService } from './recipes/recipe-repository.service';
import { RecipeService } from './recipes/recipe.service';
import { RecipesModule } from './recipes/recipes.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RecipesModule
  ],
  providers: [RecipeRepositoryService, RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

