package dh.covid.api.models.internal.dto;

import dh.covid.api.models.internal.vo.VaccinationSeries;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class CountryDTO {

    private Integer id;
    private String isoCode;
    private String name;
    private List<VaccineDTO> vaccines;
    private Date lastObservationDate;
    private String sourceName;
    private String sourceWebsite;
    private List<VaccinationSeriesDTO> vaccineSeries;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VaccineDTO> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<VaccineDTO> vaccines) {
        this.vaccines = vaccines;
    }

    public Date getLastObservationDate() {
        return lastObservationDate;
    }

    public void setLastObservationDate(Date lastObservationDate) {
        this.lastObservationDate = lastObservationDate;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceWebsite() {
        return sourceWebsite;
    }

    public void setSourceWebsite(String sourceWebsite) {
        this.sourceWebsite = sourceWebsite;
    }

    public List<VaccinationSeriesDTO> getVaccineSeries() {
        return vaccineSeries;
    }

    public void setVaccineSeries(List<VaccinationSeriesDTO> vaccineSeries) {
        this.vaccineSeries = vaccineSeries;
    }
}
