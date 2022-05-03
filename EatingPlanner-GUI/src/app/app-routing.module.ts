import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlanComponent } from './features/plan/plan.component';
import { ProductsComponent } from './features/products/products.component';
import { ShoppingListComponent } from './features/shopping-list/shopping-list.component';
import { StatisticsComponent } from './features/statistics/statistics.component';
import { RecipesComponent } from './recipes/recipes.component';

const routes: Routes = [
  { path: 'recipes', component: RecipesComponent },
  { path: 'plans', component: PlanComponent },
  { path: 'statistics', component: StatisticsComponent },
  { path: 'shopping-list', component: ShoppingListComponent },
  { path: 'products', component: ProductsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
