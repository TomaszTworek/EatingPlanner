import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'eatp-recipes-menu',
  templateUrl: './recipes-menu.component.html',
  styleUrls: ['./recipes-menu.component.scss']
})
export class RecipesMenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  goToAddRecipe(): void {
    this.router.navigate(['recipes/add']);
  }
}
