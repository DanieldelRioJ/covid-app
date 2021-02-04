import {Country} from "./country";

export interface VaccinationSeries{
  id: number;
  country: Country;
  date: Date;
  totalVaccinations: number;
  peopleVaccinated: number;
  peopleFullyVaccinated: number;
  dailyVaccinationsRaw: number;
  dailyVaccionations: number;
  totalVaccinationsPerHundred: number;
  peopleVaccinatedPerHundred: number;
  fullyVaccinatedPerHundred: number;
  dailyVaccionationsPerMillion: number;
}
