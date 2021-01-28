package dh.covid.api.services;

import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import dh.covid.api.models.internal.vo.Vaccine;

import java.util.List;

public interface DataDumper {
    void dumpData(List<Country> countries, List<Vaccine> vaccines, List<VaccinationSeries> vaccinationSeries);
    void dumpData(List<Country> countries);

    void autoReload() throws Exception;
}
