import { Injectable } from '@angular/core';
import { RecipeResponse } from 'src/app/features/recipes/models/recipe-response.model';
import { FileUploadService } from './file-upload.service';
import { RecipeRepositoryService } from './recipe-repository.service';

@Injectable({
  providedIn: 'root'
})
export class InitialDataService {

  recipes: RecipeResponse[] = [];

  constructor(private recipeRepo: RecipeRepositoryService, private fileUpload: FileUploadService) { }

  public initRecipes() {
    this.recipeRepo.getRecipesTest().subscribe(
      data => {
        console.log('recipes', data)
        data.forEach(element => {
          console.log(element.name)

          this.fileUpload.getFile(element.name)
            .subscribe(image => {

              console.log('image', image)
              let reader = new FileReader();
              if (image && image.size > 0) {

                reader.addEventListener("load", () => {
                  let recipe = new RecipeResponse(
                    element.name, element.description,
                    element.preparingTime, reader.result
                  );
                  console.log(recipe)
                  this.recipes.push(recipe);
                }, false);
                reader.readAsDataURL(image);
              }
            },
              imageError => {
                console.log('Error while download image')
              });
        });
      },
      recipeError => {
        console.log('Error while download recipe')
      }
    );
  }


  public getRecipes(): RecipeResponse[] {
    return this.recipes;
  }

  public setRecipes(recipes: RecipeResponse[]) {
    this.recipes = recipes;
  }

  public areImagesLoaded(): boolean {
   return this.recipes.length === 0;
  }
}
