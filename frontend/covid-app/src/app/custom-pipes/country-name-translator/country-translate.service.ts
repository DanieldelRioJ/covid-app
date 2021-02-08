import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CountryTranslateService {

  baseUrl = environment.apiUrl;
  transalteObjects = {};

  constructor(private httpClient: HttpClient) { }

  getTranslateObject(lang: string): Observable<any>{
    let translateObj = this.transalteObjects[lang];
    if(translateObj != null){
      return of(translateObj);
    }
    return this.httpClient.get(`/assets/${lang}/countries.json`).pipe(result => this.transalteObjects[lang] = result);
  }

}
