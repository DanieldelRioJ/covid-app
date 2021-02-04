import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from './app.component';
import {NotFoundComponent} from "./not-found/not-found.component";
import {GeneralComponent} from "./general/general.component";
import {CountryComponent} from "./country/country.component";

const routes: Routes = [
  {path: '404', component: NotFoundComponent},
  { path: '', component: GeneralComponent, pathMatch: 'full'},
  { path: 'countries', component: CountryComponent},
  { path: '**', redirectTo: '/404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
