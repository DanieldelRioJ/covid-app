package dh.covid.api.models.internal.vo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Country {
    @Id
    @Column(name = "iso_code")
    private String isoCode;

    private String name;

    @ManyToMany
    private List<Vaccine> vaccines;

    @Column(name = "last_observation_date")
    @Temporal(TemporalType.DATE)
    private Date lastObservationDate;

    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "source_website")
    private String sourceWebsite;

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
}
