import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
/*
  HtttpClient
    Comes from the @angluar/common/http package
    Provides a client HttpAPI for your Angular applications
    Build on top of the XMLHttpRequest interface
    can be injected into a service
    HttpClient methods include:
      .get()
      .post()
      .delete()
      etc
*/



@Component({
  selector: 'app-pokeapi',
  templateUrl: './pokeapi.component.html',
  styleUrls: ['./pokeapi.component.css']
})
export class PokeapiComponent implements OnInit {
  pokeId;
  pkmn = {
    name:"",
    id:"",
    weight:"",
    sprite:"",
    sprites:[],
    spriteIndex:0
  }
  constructor(private http: HttpClient) { 
    /*
      Whenever you place a parameter in the constructor with the
      'private' access modifier, you are telling angular to inject
      an instance of that object for you. Nowhere in the code do I create
      this object, it is created for me, and provided to me, by Angular.
      This process is called Dependency Injection, and it is a design
      pattern.

      A pattern where you abstract the need for individual components
      to handle its own dependencies, and instead have a parent component
      handle the injection of instances of those dependencies instead

    */
  }

  ngOnInit() {
  }

  /*
    Promises and Observables

    A Promise is a type of object where a user sends data, we guarantee
    that we will be getting something back. We don't know what, and we
    don't know when, but we will get something. In order to handle this
    promises (as well as observables) are primarily used in 
    asynchronous data exchange.
    As for the differences, promises can only listen to one event at a
    time. On top of this, once a promise starts getting data, you cannot
    interrupt it without breaking it.
    Observables can listen to multiple events at once. As well as you can
    stop an observable at any point in time once it starts streaming
    data.
  */

  public fetchData(){
    this.pkmn.name="pending";
    this.pkmn.id="pending";
    this.pkmn.weight="pending";
    this.pkmn.sprite="pending";
    this.pkmn.sprite = "ps://media.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy.gif";
    this.pkmn.sprites =[];
    this.pkmn.spriteIndex =0;

    this.http.get("https://pokeapi.co/api/v2/pokemon/"
      + this.pokeId+"/").subscribe(
        data => {
          this.pkmn.name=data["name"];
          this.pkmn.id = data["id"];
          this.pkmn.weight = data["weight"];

          let dataSprites = data["sprites"];
          for (let index in dataSprites){
            if(dataSprites[index]!=null){
              this.pkmn.sprites.push(dataSprites[index]);
              if (index == "front_default"){
                this.pkmn.sprite = dataSprites[index];
                this.pkmn.spriteIndex = this.pkmn.sprites.length -1;
              }
            }
          }
        },
        error =>{
          this.pkmn.name ="MissingNo";
          this.pkmn.id="-1";
          this.pkmn.weight="What?";
          this.pkmn.sprite="N/A";
        }
      )
  }

  changePicture(){
    let sprites = this.pkmn.sprites;
    let index = this.pkmn.spriteIndex;
    if(sprites[index +1]==undefined){
      this.pkmn.sprite = sprites[0];
      this.pkmn.spriteIndex = 0;
    }else{
      this.pkmn.sprite = sprites[++index];
      this.pkmn.spriteIndex = index;
    }
  }



}
