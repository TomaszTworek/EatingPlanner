import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { MainViewModule } from './main-view/main-view.module';
import { RecipeRepositoryService } from './recipes/recipe-repository.service';
import { RecipeService } from './recipes/recipe.service';
import { RecipesModule } from './recipes/recipes.module';
import { AppRoutingModule } from './app-routing.module';
import { PlanComponent } from './features/plan/plan.component';
import { ShoppingListComponent } from './features/shopping-list/shopping-list.component';
import { StatisticsComponent } from './features/statistics/statistics.component';
import { ProductsComponent } from './features/products/products.component';

@NgModule({
  declarations: [
    AppComponent,
    PlanComponent,
    ShoppingListComponent,
    StatisticsComponent,
    ProductsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RecipesModule,
    MainViewModule,
    AppRoutingModule
  ],
  providers: [RecipeRepositoryService, RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

