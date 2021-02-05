import { Component, OnInit } from '@angular/core';
import {CountryService} from "../api-services/country.service";
import {ActivatedRoute} from "@angular/router";
import {Country} from "../model/country";
import {VaccinationSeries} from "../model/vaccination-series";

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.scss']
})
export class CountryComponent implements OnInit {

  country: Country;
  yesterdayData: VaccinationSeries;
  todayData: VaccinationSeries;

  constructor(private countryService: CountryService,
              private route: ActivatedRoute) {
    route.params.subscribe(parameters => {
      let countryIdentifier = parameters['countryIdentifier'];
      let subscription = countryService.getCountry(countryIdentifier).subscribe(country => {
        this.country = country;
        this.yesterdayData = this.country.vaccineSeries[this.country.vaccineSeries.length - 2];
        this.todayData = this.country.vaccineSeries[this.country.vaccineSeries.length - 1];
      }, error => {

      }, () => {subscription.unsubscribe()});
    })
  }

  ngOnInit(): void {
  }

}
