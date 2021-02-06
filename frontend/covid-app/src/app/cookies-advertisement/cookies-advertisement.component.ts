import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cookies-advertisement',
  templateUrl: './cookies-advertisement.component.html',
  styleUrls: ['./cookies-advertisement.component.scss']
})
export class CookiesAdvertisementComponent implements OnInit {

  closed = true;

  constructor() {
    if(localStorage.getItem('cookies-closed') != 'true'){
      this.closed = false;
    }
  }

  ngOnInit(): void {
  }

  accept() {
    this.closed = true;
    localStorage.setItem('cookies-closed', 'true');
  }
}
