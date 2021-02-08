import { CountryNameTranslatorPipe } from './country-name-translator.pipe';

describe('CountryNameTranslatorPipe', () => {
  it('create an instance', () => {
    const pipe = new CountryNameTranslatorPipe();
    expect(pipe).toBeTruthy();
  });
});
