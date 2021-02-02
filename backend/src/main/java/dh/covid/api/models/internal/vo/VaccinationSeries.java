package dh.covid.api.models.internal.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import dh.covid.api.utils.LocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vaccination_series")
public class VaccinationSeries {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnoreProperties(value = "vaccineSeries")
    private Country country;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "total_vaccinations")
    private Long totalVaccionations;

    @Column(name = "people_vaccinated")
    private Long peopleVaccinated;

    @Column(name = "people_fully_vaccinated")
    private Long peopleFullyVaccinated;

    @Column(name = "daily_vaccinations_raw")
    private Long dailyVaccinationsRaw;

    @Column(name = "daily_vaccinations")
    private Long dailyVaccionations;

    @Column(name = "total_vaccinations_per_hundred")
    private Double totalVaccinationsPerHundred;

    @Column(name = "people_vaccinated_per_hundred")
    private Double peopleVaccinatedPerHundred;

    @Column(name = "people_fully_vaccinated_per_hundred")
    private Double fullyVaccinatedPerHundred;

    @Column(name = "daily_vaccinations_per_million")
    private Long dailyVaccionationsPerMillion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTotalVaccionations() {
        return totalVaccionations;
    }

    public void setTotalVaccionations(Long totalVaccionations) {
        this.totalVaccionations = totalVaccionations;
    }

    public Long getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public void setPeopleVaccinated(Long peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }

    public Long getPeopleFullyVaccinated() {
        return peopleFullyVaccinated;
    }

    public void setPeopleFullyVaccinated(Long peopleFullyVaccinated) {
        this.peopleFullyVaccinated = peopleFullyVaccinated;
    }

    public Long getDailyVaccinationsRaw() {
        return dailyVaccinationsRaw;
    }

    public void setDailyVaccinationsRaw(Long dailyVaccinationsRaw) {
        this.dailyVaccinationsRaw = dailyVaccinationsRaw;
    }

    public Long getDailyVaccionations() {
        return dailyVaccionations;
    }

    public void setDailyVaccionations(Long dailyVaccionations) {
        this.dailyVaccionations = dailyVaccionations;
    }

    public Double getTotalVaccinationsPerHundred() {
        return totalVaccinationsPerHundred;
    }

    public void setTotalVaccinationsPerHundred(Double totalVaccinationsPerHundred) {
        this.totalVaccinationsPerHundred = totalVaccinationsPerHundred;
    }

    public Double getPeopleVaccinatedPerHundred() {
        return peopleVaccinatedPerHundred;
    }

    public void setPeopleVaccinatedPerHundred(Double peopleVaccinatedPerHundred) {
        this.peopleVaccinatedPerHundred = peopleVaccinatedPerHundred;
    }

    public Double getFullyVaccinatedPerHundred() {
        return fullyVaccinatedPerHundred;
    }

    public void setFullyVaccinatedPerHundred(Double fullyVaccinatedPerHundred) {
        this.fullyVaccinatedPerHundred = fullyVaccinatedPerHundred;
    }

    public Long getDailyVaccionationsPerMillion() {
        return dailyVaccionationsPerMillion;
    }

    public void setDailyVaccionationsPerMillion(Long dailyVaccionationsPerMillion) {
        this.dailyVaccionationsPerMillion = dailyVaccionationsPerMillion;
    }
}
