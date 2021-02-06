import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'numberFomat'
})
export class NumberFomatPipe implements PipeTransform {

  transform(value: number): string {
    if(value == null) return null;
    return value.toLocaleString('es');
  }

}
