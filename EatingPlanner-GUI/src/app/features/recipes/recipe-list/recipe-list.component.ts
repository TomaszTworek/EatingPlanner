import { Component, OnInit } from '@angular/core';
import { FileUploadService } from 'src/app/core/services/file-upload.service';
import { RecipeRepositoryService } from 'src/app/core/services/recipe-repository.service';
import { RecipeResponse } from '../models/recipe-response.model';

@Component({
  selector: 'eatp-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {

  constructor(
    private recipeRepo: RecipeRepositoryService,
    private fileUpload: FileUploadService
  ) { }

  recipes: RecipeResponse[] = [];
  image: any;

  ngOnInit(): void {
    if (this.recipes.length === 0) {
      this.recipeRepo.getRecipesTest().subscribe({
        next: (data) => {
          console.log('recipes', data)
          data.forEach(element => {
            console.log(element.name)

            this.fileUpload.getFile(element.name).subscribe({
              next: (image) => {
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
              error: (imageError) => {
                console.log('Error while download image')
              }
            });
          })
        },
        error: (recipeError) => {
          console.log('Error while download recipe')
        }
      });
    }
  }
}
