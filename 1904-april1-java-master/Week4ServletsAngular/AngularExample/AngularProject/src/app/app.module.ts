//modules:
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
//components:
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { PokeapiComponent } from './components/pokeapi/pokeapi.component';
import { PolkamanDbComponent } from './components/polkaman-db/polkaman-db.component';

//@NgModule is a decorator that denotes that this is a  module
//somwhat analogous to the @Component decorotor for components
@NgModule({
  declarations: [//Declare all components that are being used in module
    AppComponent, HomeComponent, NavbarComponent, DirectivesComponent, DatabindingComponent, PokeapiComponent, PolkamanDbComponent
  ],
  imports: [//imports are reserved for bundles of components/services etc.
    //aka modules
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
