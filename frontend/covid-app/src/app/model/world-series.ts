export interface WorldSeries{
  id: number;
  isoCode: string;
  name: string;
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
