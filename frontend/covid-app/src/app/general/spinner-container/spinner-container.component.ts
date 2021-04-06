import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-spinner-container',
  templateUrl: './spinner-container.component.html',
  styleUrls: ['./spinner-container.component.scss']
})
export class SpinnerContainerComponent implements OnInit {

  @Input() loading: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

}
