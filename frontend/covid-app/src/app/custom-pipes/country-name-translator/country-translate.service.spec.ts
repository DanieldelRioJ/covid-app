import { TestBed } from '@angular/core/testing';

import { CountryTranslateService } from './country-translate.service';

describe('CountryTranslateService', () => {
  let service: CountryTranslateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CountryTranslateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
