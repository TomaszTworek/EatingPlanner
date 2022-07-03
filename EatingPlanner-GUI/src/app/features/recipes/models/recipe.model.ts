import { RecipeImageInformation } from "./recipe-image-information.model";

export class Recipe {
    constructor(public name: string, public description: string, public preparingTime: number, public recipeImageInformation: RecipeImageInformation) { }
}
