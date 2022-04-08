import { RecipeImage } from "./recipe-image.model";

export class Recipe {
    constructor(public name: string, public description: string, public recipeImage: RecipeImage) { }
}
