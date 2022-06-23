import { Component } from '@angular/core';
import { InitialDataService } from './core/services/initial-data.service';

@Component({
  selector: 'eatp-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'EatingPlanner-GUI';
  
  constructor() { }

  ngOnInit() {
  }
 
}
