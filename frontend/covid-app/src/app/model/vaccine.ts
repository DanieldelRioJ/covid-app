import {Country} from "./country";

export interface Vaccine{
  id: number;
  name: string;
  numberOfCountries: number;
  countries: Country[]
}
