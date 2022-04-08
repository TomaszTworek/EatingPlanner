import { RecipeImage } from "./models/recipe-image.model";
import { Recipe } from "./models/recipe.model";

export class RecipeService {

    private recipes: Recipe[] = [
        new Recipe('Test recipe1', 'TEst desc1', new RecipeImage('test', 'https://cdn.pixabay.com/photo/2012/02/16/12/08/test-13394_1280.jpg')),
        new Recipe('Test recipe2', 'TEst desc2', new RecipeImage('test', 'https://cdn.pixabay.com/photo/2012/02/16/12/08/test-13394_1280.jpg')),
        new Recipe('Test recipe3', 'TEst desc3', new RecipeImage('test', 'https://cdn.pixabay.com/photo/2012/02/16/12/08/test-13394_1280.jpg')),
    ]


    getRecipes() {
        return this.recipes.slice();
    }
}