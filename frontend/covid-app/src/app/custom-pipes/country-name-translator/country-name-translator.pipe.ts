import { Pipe, PipeTransform } from '@angular/core';
import {en} from './files/en'
import {es} from './files/es'
import {TranslateService} from "@ngx-translate/core";
import {Country} from "../../model/country";

@Pipe({
  name: 'countryNameTranslator'
})
export class CountryNameTranslatorPipe implements PipeTransform {

  langObj = {"en":en, "es":es};

  constructor(private translateService: TranslateService) {
  }

  transform(country: Country, isBack?:boolean): string {
    if(country == null) return null;
    let lang = this.translateService.currentLang;
    if(isBack){
      lang = 'en';
    }
    let countryISO = country.isoCode.toLowerCase();
    let langObject = this.langObj[lang];
    let filtered = langObject.filter(l => l.alpha3 == countryISO);
    if(filtered.length == 0){
      return country.name;
    }
    let translation = filtered[0].name;
    return translation;
  }

}
