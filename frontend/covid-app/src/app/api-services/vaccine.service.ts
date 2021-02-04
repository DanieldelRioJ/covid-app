import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vaccine} from "../model/vaccine";
import {environment} from 'src/environments/environment'
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class VaccineService {

  baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getVaccines(): Observable<Vaccine[]>{
    return this.http.get<Vaccine[]>(`${this.baseUrl}/vaccines`);
  }
}
