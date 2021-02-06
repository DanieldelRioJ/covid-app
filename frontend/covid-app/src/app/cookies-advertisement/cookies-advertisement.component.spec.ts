import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CookiesAdvertisementComponent } from './cookies-advertisement.component';

describe('CookiesAdvertisementComponent', () => {
  let component: CookiesAdvertisementComponent;
  let fixture: ComponentFixture<CookiesAdvertisementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CookiesAdvertisementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CookiesAdvertisementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
