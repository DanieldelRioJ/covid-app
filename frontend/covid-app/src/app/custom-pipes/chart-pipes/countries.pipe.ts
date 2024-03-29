import { Pipe, PipeTransform } from '@angular/core';
import {Country} from "../../model/country";
import * as moment from 'moment';
import {CountryNameTranslatorPipe} from "../country-name-translator/country-name-translator.pipe";

@Pipe({
  name: 'countries'
})
export class CountriesPipe implements PipeTransform {

  constructor(private countryNameTranslator: CountryNameTranslatorPipe) {
  }


  transform(list: Country[], property: string): any {
    if(list == null){
      return []
    }
    let result = list.filter(country => country != null).map(country => {
      let series = country.vaccineSeries.filter(vaccineSerie => vaccineSerie[property] != null).map(vaccineSerie => {
        return {
          name: new Date(vaccineSerie.date),
          value:vaccineSerie[property]
        };
      });
      return {
        name: this.countryNameTranslator.transform(country),
        series: series
      }
    });
    return result;
  }

}
