import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {MediaMatcher} from "@angular/cdk/layout";
import {TranslateService} from "@ngx-translate/core";
import {browser} from "protractor";

@Component({
  selector: 'app-country-chart',
  templateUrl: './country-chart.component.html',
  styleUrls: ['./country-chart.component.scss']
})
export class CountryChartComponent implements OnInit {

  @Input() data: any[];
  legendTitle: string = 'Legend';
  legendPosition = "right";


  // options
  legend: boolean = true;
  @Input() showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  @Input() showYAxisLabel: boolean = true;
  @Input() showXAxisLabel: boolean = true;
  @Input() xAxisLabel: string = 'Date';
  @Input() yAxisLabel: string = '% people vaccinated';
  timeline: boolean = true;

  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;

  constructor(private translate: TranslateService,
              changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
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
    this.translate.get('util.legend').subscribe(translation => {
      this.legendTitle = translation;
    })
  }

  ngOnInit(): void {
  }

  dateTickFormatting(val: any): string {
    if (val instanceof Date) {
      return (<Date>val).toLocaleString(navigator.language, {month: 'short', day:'2-digit'});
    }
  }

}
