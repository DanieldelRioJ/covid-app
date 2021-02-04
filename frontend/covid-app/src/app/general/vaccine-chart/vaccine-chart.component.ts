import {Component, Input, OnInit} from '@angular/core';
import {Vaccine} from "../../model/vaccine";
import { single } from './data';

@Component({
  selector: 'app-vaccine-chart',
  templateUrl: './vaccine-chart.component.html',
  styleUrls: ['./vaccine-chart.component.scss']
})
export class VaccineChartComponent implements OnInit {

  @Input() vaccines: Vaccine[];
  single: any[];

  //options
  gradient: boolean = true;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;
  legendPosition: string = 'below';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  constructor() {
    Object.assign(this, { single });
  }

  onSelect(data): void {
    console.log('Item clicked', JSON.parse(JSON.stringify(data)));
  }

  onActivate(data): void {
    console.log('Activate', JSON.parse(JSON.stringify(data)));
  }

  onDeactivate(data): void {
    console.log('Deactivate', JSON.parse(JSON.stringify(data)));
  }

  ngOnInit(): void {
  }

}
