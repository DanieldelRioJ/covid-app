import { CountriesPipe } from './country.pipe';

describe('CountryPipe', () => {
  it('create an instance', () => {
    const pipe = new CountriesPipe();
    expect(pipe).toBeTruthy();
  });
});
