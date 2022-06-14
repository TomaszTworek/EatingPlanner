import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { concat, concatMap, Observable } from 'rxjs';
import { FileUploadService } from 'src/app/shared/repositories/file-upload.service';
import { RecipeRepositoryService } from 'src/app/shared/repositories/recipe-repository.service';
import { Recipe } from '../recipes/models/recipe.model';

@Component({
  selector: 'eatp-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.scss']
})
export class AddRecipeComponent implements OnInit {

  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';
  fileInfos?: Observable<any>;

  recipeForm = this.fb.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    preparingTime: ['', Validators.required]
  })

  constructor
    (
      private fb: FormBuilder,
      private recipeRepo: RecipeRepositoryService,
      private router: Router,
      private uploadService: FileUploadService
    ) { }

  ngOnInit(): void { }

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }


  onSubmit(): void {
    // TODO: Use EventEmitter with form value
    console.warn(this.recipeForm.value);
    

    let file: File | null  = null;

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
    ).subscribe(
      response => {
        console.log(recipeToAdd);
      },
      error => {
        alert('An error has occurred while saving patient');
      }
    );
  }

  goToRecipeList(): void {
    this.router.navigate(['recipes']);
  }

  upload(): void {
    console.log('UPLOADED STARTED', this.selectedFiles)
    this.progress = 0;
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
      if (file) {
        this.currentFile = file;
        console.log(this.currentFile)
        this.uploadService.upload(this.currentFile!, this.recipeForm.value.name).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              this.fileInfos = this.uploadService.getFiles();
            }
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'Could not upload the file!';
            }
            this.currentFile = undefined;
          });
      }
      this.selectedFiles = undefined;
    }
  }

}
