import { Component, Input, OnInit } from '@angular/core';
import { RecipeResponse } from '../../models/recipe-response.model';

@Component({
  selector: 'eatp-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.scss']
})
export class RecipeItemComponent implements OnInit {

  constructor() { }

  @Input() recipe !: RecipeResponse;

  ngOnInit(): void {
  }

}
