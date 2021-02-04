import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccineChartComponent } from './vaccine-chart.component';

describe('VaccineChartComponent', () => {
  let component: VaccineChartComponent;
  let fixture: ComponentFixture<VaccineChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VaccineChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccineChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
