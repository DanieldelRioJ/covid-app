import { Component, OnInit } from '@angular/core';
import {CountryService} from "../api-services/country.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Country} from "../model/country";
import {VaccinationSeries} from "../model/vaccination-series";
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.scss']
})
export class CountryComponent implements OnInit {
  //Icons//
  faArrowLeft = faArrowLeft;

  country: Country;
  yesterdayData: VaccinationSeries;
  todayData: VaccinationSeries;


  constructor(private countryService: CountryService,
              private route: ActivatedRoute,
              private router: Router) {
    route.params.subscribe(parameters => {
      let countryIdentifier = parameters['countryIdentifier'];
      let subscription = countryService.getCountry(countryIdentifier).subscribe(country => {
        debugger;
        this.country = country;
        this.yesterdayData = this.country.vaccineSeries[this.country.vaccineSeries.length - 2];
        this.todayData = this.country.lastVaccineSeries;
        console.log(this.yesterdayData)
        console.log(this.todayData)
      }, error => {
        router.navigateByUrl('/404');
      }, () => {subscription.unsubscribe()});
    })
  }

  ngOnInit(): void {
  }

}
