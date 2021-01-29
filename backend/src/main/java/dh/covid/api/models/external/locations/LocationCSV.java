package dh.covid.api.models.external.locations;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.utils.LocalDateConverter;

import java.time.LocalDate;
import java.util.Date;

public class LocationCSV {

    @CsvBindByName(column = "location")
    private String location; //country name

    @CsvBindByName(column = "iso_code")
    private String isoCode;

    @CsvBindByName(column = "source_name")
    private String sourceName; //country name


    @CsvCustomBindByName(column = "last_observation_date", converter = LocalDateConverter.class)
    private LocalDate lastObservationDate;

    @CsvBindByName(column = "vaccines")
    private String vaccines; //country name

    @CsvBindByName(column = "source_website")
    private String sourceWebsite; //country name

    public LocationCSV(){}

    public LocationCSV(String location, String isoCode) {
        this.location = location;
        this.isoCode = isoCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public LocalDate getLastObservationDate() {
        return lastObservationDate;
    }

    public void setLastObservationDate(LocalDate lastObservationDate) {
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

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }
}
