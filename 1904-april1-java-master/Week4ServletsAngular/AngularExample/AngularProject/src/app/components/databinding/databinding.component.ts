import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {
  variable = "SECRET MESSAGE :D"
  visibility = true;
  userInput ="";
  toggleVisibility(){
    this.visibility = !this.visibility;
  }
  constructor() { }

  ngOnInit() {
  }

}
