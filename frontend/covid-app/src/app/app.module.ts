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
import { CountryPipe } from './custom-pipes/chart-pipes/country.pipe';
import { MomentModule } from 'angular2-moment';
import { VaccinePipe } from './custom-pipes/chart-pipes/vaccine.pipe';

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
    CountryPipe,
    VaccinePipe
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
    MomentModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
