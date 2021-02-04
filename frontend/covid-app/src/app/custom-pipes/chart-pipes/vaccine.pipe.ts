import { Pipe, PipeTransform } from '@angular/core';
import {Vaccine} from "../../model/vaccine";

@Pipe({
  name: 'vaccine'
})
export class VaccinePipe implements PipeTransform {

  transform(list: Vaccine[]): unknown {
    if(list == null) return [];
    return list.map(vaccine => {
      return {
        name: vaccine.name,
        value: vaccine.numberOfCountries
      }
    });
  }

}
