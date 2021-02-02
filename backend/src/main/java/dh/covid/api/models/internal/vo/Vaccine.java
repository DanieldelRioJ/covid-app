package dh.covid.api.models.internal.vo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Vaccine {

    @Id
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "vaccines")
    private List<Country> countries;

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
}
