package dh.covid.api.models.internal.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Vaccine {

    @Id
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "vaccines")
    @JsonIgnoreProperties(value = {"vaccines", "vaccineSeries"})
    private List<Country> countries;

    @Transient
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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Integer getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setNumberOfCountries(Integer numberOfCountries) {
        this.numberOfCountries = numberOfCountries;
    }

    @PostLoad
    private void onLoad(){
        if(this.countries != null){
            this.numberOfCountries = this.countries.size();
        }
    }
}
