import { Component, OnInit } from '@angular/core';
import { RecipeRepositoryService } from '../recipe-repository.service';
import { Recipe } from '../models/recipe.model';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'eatp-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [];

  constructor(private recipeService: RecipeService, private recipeRepo: RecipeRepositoryService) { }

  ngOnInit(): void {
    this.recipeRepo.getRecipesTest().subscribe(
      data => {
        console.log(data);
        this.recipes = data}
    );
  }

}
