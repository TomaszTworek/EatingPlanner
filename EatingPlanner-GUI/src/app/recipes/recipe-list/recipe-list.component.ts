import { Component, OnInit } from '@angular/core';
import { RecipeRepositoryService } from '../../shared/repositories/recipe-repository.service';
import { Recipe } from '../models/recipe.model';

@Component({
  selector: 'eatp-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [];

  constructor(private recipeRepo: RecipeRepositoryService) { }

  ngOnInit(): void {
    this.recipeRepo.getRecipesTest().subscribe(
      data => {
        console.log(data);
        this.recipes = data}
    );
  }

}
