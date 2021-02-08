import { Pipe, PipeTransform } from '@angular/core';
import {Country} from "../../model/country";

@Pipe({
  name: 'country'
})
export class CountryPipe implements PipeTransform {

  transform(country: Country, type?:string): unknown {
    if(country == null) return [];
    if(type == null) type = '%';
    let props;
    if(type == '%'){
      props = ['totalVaccinationsPerHundred','peopleVaccinatedPerHundred','fullyVaccinatedPerHundred'];
    }else if(type == 'daily'){
      props = ['dailyVaccionations']
    }else{
      props = ['totalVaccinations','peopleVaccinated','peopleFullyVaccinated']
    }

    let result = props.map(property => {
      let series = country.vaccineSeries.filter(vaccine => vaccine[property] != null).map(vaccineSerie => {

        return {
          name: new Date(vaccineSerie.date),
          value:vaccineSerie[property]
        };
      });
      return {
        name: property,
        series: series
      }
    });
    return result;
  }

}
