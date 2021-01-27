package dh.covid.api.models.external.locations;

import com.opencsv.bean.CsvBindByName;
import dh.covid.api.models.external.vaccinations.VaccinationData;

public class LocationData {

    @CsvBindByName(column = "location")
    private String location; //country name

    @CsvBindByName(column = "iso_code")
    private String isoCode;
    private VaccinationData vaccinationData;

    public LocationData(){}

    public LocationData(String location, String isoCode) {
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

    public VaccinationData getCountryVaccionationData() {
        return vaccinationData;
    }

    public void setCountryVaccionationData(VaccinationData vaccinationData) {
        this.vaccinationData = vaccinationData;
    }
}
