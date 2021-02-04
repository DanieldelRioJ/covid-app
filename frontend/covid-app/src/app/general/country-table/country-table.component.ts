import {Component, Input, OnInit} from '@angular/core';
import {Country} from "../../model/country";

@Component({
  selector: 'app-country-table',
  templateUrl: './country-table.component.html',
  styleUrls: ['./country-table.component.scss']
})
export class CountryTableComponent implements OnInit {


  @Input() countries:Country[];
  displayedColumns: string[] = ['position', 'name', 'data'];
  constructor() { }

  ngOnInit(): void {
  }

}
