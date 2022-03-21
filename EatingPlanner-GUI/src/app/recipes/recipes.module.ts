import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RecipeDetailComponent } from "./recipe-list/recipe-detail/recipe-detail.component";
import { RecipeListComponent } from "./recipe-list/recipe-list.component";
import { RecipesComponent } from "./recipes.component";

@NgModule({
    declarations: [
        RecipesComponent,
        RecipeDetailComponent,
        RecipeListComponent
    ],
    imports: [CommonModule], //BrowserModule but simplier
    exports: [
        RecipesComponent,
        RecipeDetailComponent,
        RecipeListComponent
    ]
})
export class RecipesModule {

}