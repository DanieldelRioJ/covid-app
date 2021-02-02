package dh.covid.api.models.internal.dto;

import javax.persistence.*;
import java.util.Date;

public class VaccinationSeriesDTO {

    private Long id;
    private CountryDTO country;
    private Date date;
    private Long totalVaccionations;
    private Long peopleVaccinated;
    private Long peopleFullyVaccinated;
    private Long dailyVaccinationsRaw;
    private Long dailyVaccionations;
    private Double totalVaccinationsPerHundred;
    private Double peopleVaccinatedPerHundred;
    private Double fullyVaccinatedPerHundred;
    private Long dailyVaccionationsPerMillion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
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
