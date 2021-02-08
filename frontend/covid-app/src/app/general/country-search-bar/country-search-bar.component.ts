import { Component, OnInit } from '@angular/core';
import {Country} from "../../model/country";
import {map, startWith} from "rxjs/operators";
import {CountryService} from "../../api-services/country.service";
import {WorldService} from "../../api-services/world.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import {CountryNameTranslatorPipe} from "../../custom-pipes/country-name-translator/country-name-translator.pipe";

@Component({
  selector: 'app-country-search-bar',
  templateUrl: './country-search-bar.component.html',
  styleUrls: ['./country-search-bar.component.scss']
})
export class CountrySearchBarComponent implements OnInit {
  //Icons//
  faSearch = faSearch;

  searchCountryFormGroup: FormGroup;
  countryNames: Country[];
  filteredCountries:Observable<Country[]>

  constructor(private countryService: CountryService,
              private fb: FormBuilder,
              private router: Router,
              private countryNameTranslator: CountryNameTranslatorPipe) {
    this.searchCountryFormGroup = fb.group({
      countryName: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    let countryNamesSub = this.countryService.getCountryNames().subscribe(names => {
      this.countryNames = names;
      countryNamesSub.unsubscribe();
      this.filteredCountries = this.searchCountryFormGroup.controls.countryName.valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value))
      );
    })
  }

  searchCountry() {
    let countryName = this.searchCountryFormGroup.value.countryName;
    let countryChoosen = this.countryNames.filter(country => {
      return this.countryNameTranslator.transform(country) == countryName
    })
    if(countryChoosen.length > 0){
      countryName = countryChoosen[0].name;
    }
    this.router.navigateByUrl(`/countries/${countryName}`);
  }

  private _filter(value: string): Country[] {
    const filterValue = value.toLowerCase();

    return this.countryNames.filter(option => {

      return this.countryNameTranslator.transform(option).toLowerCase().indexOf(filterValue) === 0
    });
  }
}
