/*
  Routing is a feature that Angular uses to acheive true
  Single Page Application format (SPA).

  Routing is where we set up a page to be injected through the url that we
  are connected to. The URLs themselves do not point to separate files
  to be displayed, due to the fact that it would then be a multi page
  application.

  Worth noting: Angular uses caching to allow us to use the back/ forward
  buttons on your browser to navigate properly. It is only one page, yet
  angular will leverage implicit bookmarks to keep track of the different
  "pages" and allow us to use the back and forward buttons as if we were
  transitioning between different pages.
*/

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { PokeapiComponent } from './components/pokeapi/pokeapi.component';
import { PolkamanDbComponent } from './components/polkaman-db/polkaman-db.component';

// declaration varibalename: datatype = expression;
const routes: Routes = [
  {
    path:'home',
    component: HomeComponent
  },
  {
    path:'pokeapi',
    component: PokeapiComponent
  },
  {
    path:'polkamandb',
    component: PolkamanDbComponent
  },
  {
    path:'databinding',
    component: DatabindingComponent
  },
  {
    path:'directives',
    component: DirectivesComponent
  },
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'**',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
