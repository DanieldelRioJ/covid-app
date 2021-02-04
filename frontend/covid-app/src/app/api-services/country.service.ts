import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Country} from "../model/country";
import {Vaccine} from "../model/vaccine";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Page} from "../model/pagination/page";

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getCountries(top?:number): Observable<Page<Country[]>>{
    let params = new HttpParams();
    if(top != null){
      params = params.append('top', top+'');
    }
    return this.http.get<Page<Country[]>>(`${this.baseUrl}/countries`, {params});
  }

  getCountry(identifier: string|number): Observable<Country[]>{
    return this.http.get<Country[]>(`${this.baseUrl}/countries/${identifier}`);
  }
}
