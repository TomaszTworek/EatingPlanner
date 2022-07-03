import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { RecipeResponse } from "src/app/features/recipes/models/recipe-response.model";
import { Recipe } from "src/app/features/recipes/models/recipe.model";

@Injectable({
    providedIn: 'root'
})
export class RecipeRepositoryService {

    private baseRecipeUrl: string = 'http://localhost:8080/recipe'

    constructor(private http: HttpClient) { }

    getRecipesTest(): Observable<RecipeResponse[]> {
        return this.http.get<RecipeResponse[]>(this.baseRecipeUrl + '/all')
    }

    addRecipe(recipe: Recipe): Observable<any> {
        return this.http.post(this.baseRecipeUrl, recipe);
    }
}