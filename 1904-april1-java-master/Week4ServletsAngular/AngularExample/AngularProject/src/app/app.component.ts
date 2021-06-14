import { Component } from '@angular/core';
/*
  Any @ you see in typescript is called a "decorator".
  Decorators describe meta data for the application and
  allow the compiler to bring in the necessary resources when compiling
  your project. For instance, the compiler knows to only bring resources
  needed for components in this class
*/
@Component({
  /*
    Describes the custom html element that will have THIS component's view
    and where it will be injected
  */
  selector: 'app-root',
  /*
    This points to the location of the html that will be used as the view.
    This html is what will be injected in the selector.
  */
  templateUrl: './app.component.html',
  /*
    Should you want to use extra css files, place them in the attached
    array for the styleUrls key.
  */
  styleUrls: ['./app.component.css']
})
/*
  Inside the class is where we can make use of variables and busniess
  logic for our app.
  Note that export class will make this component public for use thorughout
  the application
*/
export class AppComponent {
  title = 'Williams Project';
}
