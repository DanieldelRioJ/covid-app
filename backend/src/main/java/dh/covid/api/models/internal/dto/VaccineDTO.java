package dh.covid.api.models.internal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@ApiModel("Vaccine")
public class VaccineDTO {

    private Integer id;

    @ApiModelProperty(value = "Unique name of the vaccine")
    private String name;

    @ApiModelProperty(value = "List of countries where this vaccine is used")
    private List<CountryDTO> countries;

    @ApiModelProperty(value = "Number of countries that use this vaccine")
    private Integer numberOfCountries;

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

    public Integer getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setNumberOfCountries(Integer numberOfCountries) {
        this.numberOfCountries = numberOfCountries;
    }
}
