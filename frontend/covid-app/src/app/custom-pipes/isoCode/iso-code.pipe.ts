import { Pipe, PipeTransform } from '@angular/core';
import {listOfCodeRelations} from './map';
@Pipe({
  name: 'isoCode'
})
export class IsoCodePipe implements PipeTransform {

  listOfCodeRelations: any[] = listOfCodeRelations

  transform(iso3Value): string {
    let val = listOfCodeRelations.filter(country => {
      return country['alpha-3'] == iso3Value
    })[0];
    return val['alpha-2'];
  }

}
