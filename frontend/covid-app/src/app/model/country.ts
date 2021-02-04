import {Vaccine} from "./vaccine";
import {VaccinationSeries} from "./vaccination-series";

export interface Country{
  id: number;
  isoCode: string;
  name: string;
  vaccines: Vaccine[],
  lastObservactionDate: Date;
  sourceName: string;
  sourceWebsite: string;
  vaccineSeries: VaccinationSeries[];
  lastVaccineSeries: VaccinationSeries[];
}
