package dh.covid.api.models.internal.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Country {
    @Id
    private Integer id;

    @Column(name = "iso_code")
    private String isoCode;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "country_vaccine",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id"))
    @JsonIgnoreProperties(value = "countries")
    private List<Vaccine> vaccines;

    @Column(name = "last_observation_date")
    @Temporal(TemporalType.DATE)
    private Date lastObservationDate;

    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "source_website")
    private String sourceWebsite;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties(value = "country")
    private List<VaccinationSeries> vaccineSeries;

    @ManyToOne
    @JoinFormula("(SELECT vs.id FROM vaccination_series vs WHERE vs.country_id = id ORDER BY vs.date DESC LIMIT 1)")
    @JsonIgnoreProperties(value = "country")
    private VaccinationSeries lastVaccineSeries;
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

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
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

    public List<VaccinationSeries> getVaccineSeries() {
        return vaccineSeries;
    }

    public void setVaccineSeries(List<VaccinationSeries> vaccineSeries) {
        this.vaccineSeries = vaccineSeries;
    }

    public VaccinationSeries getLastVaccineSeries() {
        return lastVaccineSeries;
    }

    public void setLastVaccineSeries(VaccinationSeries lastVaccineSeries) {
        this.lastVaccineSeries = lastVaccineSeries;
    }
}
