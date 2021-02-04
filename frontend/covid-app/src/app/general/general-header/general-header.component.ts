import {Component, Input, OnInit} from '@angular/core';
import {WorldSeries} from "../../model/world-series";

import { faGlobeAmericas, faInfo } from '@fortawesome/free-solid-svg-icons';
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
  @Input() world: WorldSeries;

  constructor() { }

  ngOnInit(): void {
  }

}
