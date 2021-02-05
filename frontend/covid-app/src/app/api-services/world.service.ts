import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vaccine} from "../model/vaccine";
import {WorldSeries} from "../model/world-series";

@Injectable({
  providedIn: 'root'
})
export class WorldService {

  baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getWorldSeries(): Observable<WorldSeries[]>{
    return this.http.get<WorldSeries[]>(`${this.baseUrl}/world`);
  }

  getWorldLastSerie():Observable<WorldSeries>{
    return this.http.get<WorldSeries>(`${this.baseUrl}/world/now`);
  }

  getWorldYesterdaySerie():Observable<WorldSeries>{
    return this.http.get<WorldSeries>(`${this.baseUrl}/world/yesterday`);
  }
}
