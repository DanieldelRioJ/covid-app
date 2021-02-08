import { Component } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {MetaService} from "@ngx-meta/core";


@Component({
  selector: 'app-component',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  availableLangs = ['en', 'es']

  constructor(private translate: TranslateService) {
    let lang = navigator.language.split("-")[0];
    if(this.availableLangs.filter(l => lang == l).length > 0){
      translate.use(lang);
    }
    document.documentElement.lang = this.translate.currentLang;
  }
}
