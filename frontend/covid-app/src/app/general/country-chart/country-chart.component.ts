import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {multi} from "./data";
import {Country} from "../../model/country";
import {MediaMatcher} from "@angular/cdk/layout";

@Component({
  selector: 'app-country-chart',
  templateUrl: './country-chart.component.html',
  styleUrls: ['./country-chart.component.scss']
})
export class CountryChartComponent implements OnInit {

  @Input() data: any[];
  legendPosition = "right";
  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
    this.mobileQuery = media.matchMedia('(max-width: 700px)');
    if(this.mobileQuery.matches){
      this.legendPosition = "below";
    }
    this._mobileQueryListener = () => {
      changeDetectorRef.detectChanges();
      if(this.mobileQuery.matches){
        this.legendPosition = "below";
      }else{
        this.legendPosition = "right";
      }
    }
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;

  // options
  legend: boolean = true;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Date';
  yAxisLabel: string = '% people vaccinated';
  timeline: boolean = true;

  onSelect(data): void {
    //console.log('Item clicked', JSON.parse(JSON.stringify(data)));
  }

  onActivate(data): void {
    //console.log('Activate', JSON.parse(JSON.stringify(data)));
  }

  onDeactivate(data): void {
    //console.log('Deactivate', JSON.parse(JSON.stringify(data)));
  }

  ngOnInit(): void {
  }

}
