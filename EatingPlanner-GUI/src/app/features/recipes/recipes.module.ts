import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RecipeListComponent } from "./recipe-list/recipe-list.component";
import { RecipesComponent } from "./recipes.component";
import { RecipeItemComponent } from './recipe-list/recipe-item/recipe-item.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { RecipesMenuComponent } from './recipes-menu/recipes-menu.component';

@NgModule({
    declarations: [
        RecipesComponent,
        RecipeListComponent,
        RecipeItemComponent,
        RecipesMenuComponent
    ],
    imports: [
        CommonModule,
        MatCardModule,
        MatButtonModule,
        MatGridListModule
    ], //BrowserModule but simplier
    exports: [
        RecipesComponent,
        RecipeListComponent
    ]
})
export class RecipesModule {

}