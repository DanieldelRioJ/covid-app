import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'numberFomat'
})
export class NumberFomatPipe implements PipeTransform {

  transform(value: number, signed?: boolean): string {
    if(value == null) return null;
    let number = value.toLocaleString('es');
    if(value >= 0 && signed == true){
     return '+'+number;
    }
    return number;
  }

}
