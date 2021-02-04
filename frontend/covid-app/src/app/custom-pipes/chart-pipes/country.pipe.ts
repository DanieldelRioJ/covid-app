import { Pipe, PipeTransform } from '@angular/core';
import {Country} from "../../model/country";
import * as moment from 'moment';

@Pipe({
  name: 'country'
})
export class CountryPipe implements PipeTransform {

  constructor() {
  }


  transform(list: Country[], property: string): any {
    if(list == null){
      return []
    }
    let result = list.map(country => {
      let series = country.vaccineSeries.filter(vaccineSerie => vaccineSerie[property] != null).map(vaccineSerie => {
        return {
          name: new Date(vaccineSerie.date),
          value:vaccineSerie[property]
        };
      });
      return {
        name: country.name,
        series: series
      }
    });
    return result;
  }

}
