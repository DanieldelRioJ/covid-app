import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'numberFomat'
})
export class NumberFomatPipe implements PipeTransform {

  transform(value: number): string {
    let numberStr = value+'';

    for(let i=numberStr.length-1; i > 0; i--){

    }
    return numberStr;
  }

}
