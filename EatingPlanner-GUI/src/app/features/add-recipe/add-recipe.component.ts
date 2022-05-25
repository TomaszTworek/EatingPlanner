import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Recipe } from 'src/app/recipes/models/recipe.model';
import { RecipeRepositoryService } from 'src/app/shared/repositories/recipe-repository.service';

@Component({
  selector: 'eatp-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.scss']
})
export class AddRecipeComponent implements OnInit {

  recipeForm = this.fb.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    preparingTime: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private recipeRepo: RecipeRepositoryService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    // TODO: Use EventEmitter with form value
    console.warn(this.recipeForm.value);
    const recipeToAdd: any = {
      name: this.recipeForm.value.name,
      description: this.recipeForm.value.description,
      preparingTime: this.recipeForm.value.preparingTime
    }

    this.recipeRepo.addRecipe(recipeToAdd).subscribe(
      response => {
        console.log(recipeToAdd);
      },
      error => {
        alert('An error has occurred while saving patient');
      }
    );

  }

}
