import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from './app.component';
import {NotFoundComponent} from "./not-found/not-found.component";
import {GeneralComponent} from "./general/general.component";
import {CountryComponent} from "./country/country.component";
import {PolicyComponent} from "./policy/policy.component";

const routes: Routes = [
  {path: '404', component: NotFoundComponent},
  { path: '', component: GeneralComponent, pathMatch: 'full'},
  { path: 'policy', component: PolicyComponent, pathMatch: 'full'},
  { path: 'countries/:countryIdentifier', component: CountryComponent},
  { path: '**', redirectTo: '/404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
