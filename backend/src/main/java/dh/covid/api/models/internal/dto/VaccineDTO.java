package dh.covid.api.models.internal.dto;

import javax.persistence.*;
import java.util.List;

public class VaccineDTO {

    private Integer id;
    private String name;
    private List<CountryDTO> countries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }
}
