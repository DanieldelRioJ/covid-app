import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {NgxChartsModule} from '@swimlane/ngx-charts';
import { NotFoundComponent } from './not-found/not-found.component';
import { GeneralComponent } from './general/general.component';
import { CountryComponent } from './country/country.component';
import {HttpClientModule} from "@angular/common/http";
import {MatCardModule} from '@angular/material/card';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { GeneralHeaderComponent } from './general/general-header/general-header.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {MatTableModule} from '@angular/material/table';
import { CountryTableComponent } from './general/country-table/country-table.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import { CountryChartComponent } from './general/country-chart/country-chart.component';
import { VaccineChartComponent } from './general/vaccine-chart/vaccine-chart.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { CountriesPipe } from './custom-pipes/chart-pipes/countries.pipe';
import { VaccinePipe } from './custom-pipes/chart-pipes/vaccine.pipe';
import { IsoCodePipe } from './custom-pipes/isoCode/iso-code.pipe';
import {ReactiveFormsModule} from "@angular/forms";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import { CountrySearchBarComponent } from './general/country-search-bar/country-search-bar.component';
import { FooterComponent } from './footer/footer.component';
import { CookiesAdvertisementComponent } from './cookies-advertisement/cookies-advertisement.component';
import { NumberFomatPipe } from './custom-pipes/number-fomat.pipe';
import { PolicyComponent } from './policy/policy.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    GeneralComponent,
    CountryComponent,
    GeneralHeaderComponent,
    CountryTableComponent,
    CountryChartComponent,
    VaccineChartComponent,
    CountriesPipe,
    VaccinePipe,
    IsoCodePipe,
    CountrySearchBarComponent,
    FooterComponent,
    CookiesAdvertisementComponent,
    NumberFomatPipe,
    PolicyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    NgxChartsModule,
    HttpClientModule,
    MatCardModule,
    NgbModule,
    FontAwesomeModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatTooltipModule,
    ReactiveFormsModule,
    MatAutocompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
