import {Component, Input, OnInit} from '@angular/core';
import {WorldSeries} from "../../model/world-series";

import { faGlobeAmericas, faInfo, faShieldVirus, faSyringe, faUserShield } from '@fortawesome/free-solid-svg-icons';
import {VaccinationSeries} from "../../model/vaccination-series";
@Component({
  selector: 'app-general-header',
  templateUrl: './general-header.component.html',
  styleUrls: ['./general-header.component.scss']
})
export class GeneralHeaderComponent implements OnInit {
  //// ICONS ////
  worldIcon = faGlobeAmericas;
  faShieldVirus = faShieldVirus;
  faSyringe = faSyringe;
  faUserShield = faUserShield;
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
