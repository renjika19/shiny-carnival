import { Component, OnInit } from '@angular/core';
import { Polkaman } from './polkaman/polkaman';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {
  visible:boolean = false;
  buttonText:string = "SHOW ANSWER";

  toggleTransparency(){
    if(this.visible = !this.visible){
      this.buttonText = "HIDE ANSWER";
    }else{
      this.buttonText = "SHOW ANSWER";
    }
  }

  polkaman:Polkaman = new Polkaman("","",0);
  polkamans:Polkaman[] =[];

  submitPolkaman(){
    this.polkamans.push(
      new Polkaman(
        this.polkaman.name,
        this.polkaman.type,
        Date.now()
      )
    );
    this.polkaman.name="";
    this.polkaman.type="";
  }

  styleObject = {
    color:"black",
    backgroundColor:"lavender"
  }

  colorToggle=false;
  changeStyle(){
    if(this.colorToggle= !this.colorToggle){
      this.styleObject.color = "lavender";
      this.styleObject.backgroundColor = "black";
    }else{
      this.styleObject.color="black";
      this.styleObject.backgroundColor="lavender";
    }
  }

  constructor() { }

  ngOnInit() {
  }

}
