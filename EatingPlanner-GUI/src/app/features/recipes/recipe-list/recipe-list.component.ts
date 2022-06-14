import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { FileUploadService } from 'src/app/shared/repositories/file-upload.service';
import { RecipeRepositoryService } from 'src/app/shared/repositories/recipe-repository.service';
import { RecipeResponse } from '../models/recipe-response.model';

import { Recipe } from '../models/recipe.model';

@Component({
  selector: 'eatp-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {

  recipes: RecipeResponse[] = [];
  image: any;
  imageToShow: any = null;

  constructor(private recipeRepo: RecipeRepositoryService, private fileUpload: FileUploadService) { }

  ngOnInit(): void {
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
    // this.fileUpload.getFile("Test.jpg").subscribe(
    //   result => {
    //     this.image = this.createImage(result);
    //   },
    //   error => {
    //     console.log('RecipeListComponent.ngOnInit file load error');
    //   }
    // )
    console.log(this.recipes);

  }


  private createImage(image: Blob) {
    if (image && image.size > 0) {
      let reader = new FileReader();

      reader.addEventListener("load", () => {
        this.imageToShow = reader.result;
      }, false);

      reader.readAsDataURL(image);
    }

  }

}
