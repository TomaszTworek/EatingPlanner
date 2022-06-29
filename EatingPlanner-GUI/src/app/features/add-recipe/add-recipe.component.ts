import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxImageCompressService } from 'ngx-image-compress';
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
      private uploadService: FileUploadService,
      private imageCompress: NgxImageCompressService
    ) { }

  ngOnInit(): void { }

  compressedFile!: File;

  recipeForm = this.fb.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    preparingTime: ['', Validators.required]
  })

  selectFile(event: any): void {
    if (event.target.files && event.target.files[0]) {
      let reader = new FileReader();
      let imageName = event.target.files[0].name;
      reader.onload = (event: any) => {
        this.compressFile(event.target.result, imageName)
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  compressFile(image: any, fileName: any) {
    let orientation = -1;
    this.imageCompress.compressFile(image, orientation, 50, 50).then(
      result => {
        // create file from byte
        const imageName = fileName;
        // call method that creates a blob from dataUri
        const imageBlob = this.dataURItoBlob(result.split(',')[1]);
        //imageFile created below is the new compressed file which can be send to API in form data
        this.compressedFile = new File([imageBlob], imageName, { type: 'image/jpeg' });
      });
  }

  dataURItoBlob(dataURI: any) {
    const byteString = window.atob(dataURI);
    const arrayBuffer = new ArrayBuffer(byteString.length);
    const int8Array = new Uint8Array(arrayBuffer);
    for (let i = 0; i < byteString.length; i++) {
      int8Array[i] = byteString.charCodeAt(i);
    }
    const blob = new Blob([int8Array], { type: 'image/jpeg' });
    return blob;
  }

  onSubmit(): void {
    // TODO: Use EventEmitter with form value
    console.warn(this.recipeForm.value);

    let file: File | null = null;

    if (this.compressedFile) {
      file = this.compressedFile;
    }

    const recipeToAdd: Recipe = {
      name: this.recipeForm.value.name,
      description: this.recipeForm.value.description,
      preparingTime: this.recipeForm.value.preparingTime,
      recipeImageInformation: {
        name: this.recipeForm.value.name,
        size: this.compressedFile.size,
        extension: this.compressedFile.type
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
