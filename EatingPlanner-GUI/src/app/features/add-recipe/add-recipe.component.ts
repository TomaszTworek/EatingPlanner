import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { concatMap } from 'rxjs';
import { FileUploadService } from 'src/app/core/services/file-upload.service';
import { RecipeRepositoryService } from 'src/app/core/services/recipe-repository.service';
import { Recipe } from '../recipes/models/recipe.model';

@Component({
  selector: 'eatp-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.scss']
})
export class AddRecipeComponent implements OnInit {

  constructor
    (
      private fb: FormBuilder,
      private recipeRepo: RecipeRepositoryService,
      private router: Router,
      private uploadService: FileUploadService
    ) { }

  ngOnInit(): void { }

  selectedFiles?: FileList;

  recipeForm = this.fb.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    preparingTime: ['', Validators.required]
  })

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }

  onSubmit(): void {
    // TODO: Use EventEmitter with form value
    console.warn(this.recipeForm.value);

    let file: File | null = null;

    if (this.selectedFiles) {
      file = this.selectedFiles.item(0);
    }

    const recipeToAdd: Recipe = {
      name: this.recipeForm.value.name,
      description: this.recipeForm.value.description,
      preparingTime: this.recipeForm.value.preparingTime,
      recipeImageInformation: {
        name: this.recipeForm.value.name,
        size: file!.size,
        extension: file!.name
      }
    }

    this.recipeRepo.addRecipe(recipeToAdd).pipe(
      concatMap(() => this.uploadService.upload(file!, recipeToAdd.name))
    ).subscribe({
      next: () => console.log(recipeToAdd),
      error: () => alert('An error has occurred while saving recipe!'),
      complete: () => console.log('Post recipe completed.')
    });
  }

  goToRecipeList(): void {
    this.router.navigate(['recipes']);
  }
}
