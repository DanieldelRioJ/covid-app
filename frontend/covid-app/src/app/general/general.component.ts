import { Component, OnInit } from '@angular/core';
import {VaccineService} from "../api-services/vaccine.service";
import {Vaccine} from "../model/vaccine";
import {CountryService} from "../api-services/country.service";
import { multi } from './country-chart/data';
import {WorldSeries} from "../model/world-series";
import {WorldService} from "../api-services/world.service";
import {Country} from "../model/country";
import { faSearch } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-general',
  templateUrl: './general.component.html',
  styleUrls: ['./general.component.scss']
})
export class GeneralComponent implements OnInit {
  faSearch = faSearch;
  vaccines: Vaccine[];
  world: WorldSeries;
  countries: Country[];

  constructor(private vaccineService: VaccineService,
              private countryService: CountryService,
              private worldService: WorldService) {


  }

  ngOnInit(): void {
    let vacSub = this.vaccineService.getVaccines().subscribe(vaccines => {
      this.vaccines = vaccines;
      vacSub.unsubscribe();
    })
    let countrySub = this.countryService.getCountries(10).subscribe(page => {
      this.countries = page.content;
      countrySub.unsubscribe();
    });
    let worldSub = this.worldService.getWorldLastSerie().subscribe(world => {
      this.world = world;
      worldSub.unsubscribe();
    })
  }

}
