import { IsoCodePipe } from './iso-code.pipe';

describe('IsoCodePipe', () => {
  it('create an instance', () => {
    const pipe = new IsoCodePipe();
    expect(pipe).toBeTruthy();
  });
});
