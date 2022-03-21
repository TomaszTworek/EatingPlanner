import { Recipe } from "./recipe.model";

export class RecipeService {

    private recipes: Recipe[] = [
        new Recipe('Test recipe1', 'TEst desc1'),
        new Recipe('Test recipe2', 'TEst desc2'),
        new Recipe('Test recipe3', 'TEst desc3'),
    ]


    getRecipes() {
        return this.recipes.slice();
    }
}