import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Recipe } from "./models/recipe.model";

@Injectable()
export class RecipeRepositoryService {

    private recipeUrl: string = 'http://localhost:8080/recipe'
    constructor(private http: HttpClient) { }

    getRecipesTest(): Observable<any[]> {
        return this.http.get<Recipe[]>(this.recipeUrl + '/all')
    }
}