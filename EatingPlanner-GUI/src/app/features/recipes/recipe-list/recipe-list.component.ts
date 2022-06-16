import { Component, OnInit } from '@angular/core';
import { FileUploadService } from 'src/app/core/services/file-upload.service';
import { InitialDataService } from 'src/app/core/services/initial-data.service';
import { RecipeRepositoryService } from 'src/app/core/services/recipe-repository.service';
import { RecipeResponse } from '../models/recipe-response.model';

@Component({
  selector: 'eatp-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {

  recipes: RecipeResponse[] = [];
  image: any;
  imageToShow: any = null;

  constructor(private recipeRepo: RecipeRepositoryService, private fileUpload: FileUploadService, private data: InitialDataService) { }

  ngOnInit(): void {
    if (this.data.areImagesLoaded()) {
      let recipes: RecipeResponse[] = [];
      if (this.recipes.length === 0) {
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
                      recipes.push(recipe);
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
        this.data.setRecipes(recipes);
        console.log(this.recipes);
      }
    } else{
      this.recipes = this.data.getRecipes();
    }
  }
}
