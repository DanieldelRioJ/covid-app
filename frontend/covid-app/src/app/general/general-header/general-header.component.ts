import {Component, Input, OnInit} from '@angular/core';
import {WorldSeries} from "../../model/world-series";

import { faGlobeAmericas, faInfo } from '@fortawesome/free-solid-svg-icons';
import {VaccinationSeries} from "../../model/vaccination-series";
@Component({
  selector: 'app-general-header',
  templateUrl: './general-header.component.html',
  styleUrls: ['./general-header.component.scss']
})
export class GeneralHeaderComponent implements OnInit {
  //// ICONS ////
  worldIcon = faGlobeAmericas;
  faInfo = faInfo;
  //
  @Input() todaySerie: WorldSeries|VaccinationSeries;
  @Input() yesterdaySerie: WorldSeries|VaccinationSeries;
  @Input() headerText: string;
  @Input() isoCode: string;
  constructor() { }

  ngOnInit(): void {
  }

}
