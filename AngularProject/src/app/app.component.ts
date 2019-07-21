import { Component } from '@angular/core';

/*
This is an Angular decorator. It works similar to annotation.
*/
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularProject';
}
