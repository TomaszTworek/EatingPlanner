import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddRecipeComponent } from './features/add-recipe/add-recipe.component';
import { PlanComponent } from './features/plan/plan.component';
import { ProductsComponent } from './features/products/products.component';
import { RecipesComponent } from './features/recipes/recipes.component';
import { ShoppingListComponent } from './features/shopping-list/shopping-list.component';
import { StatisticsComponent } from './features/statistics/statistics.component';
import { FileUploadComponent } from './shared/file-upload/file-upload.component';

const routes: Routes = [
  { path: 'recipes', component: RecipesComponent },
  { path: 'plans', component: PlanComponent },
  { path: 'statistics', component: StatisticsComponent },
  { path: 'shopping-list', component: ShoppingListComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'recipes/add', component: AddRecipeComponent },
  {path: 'images', component: FileUploadComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
