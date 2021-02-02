package dh.covid.api.models.internal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "VaccinationSeries", description = "Data of 1 day vaccination of 1 country")
public class VaccinationSeriesDTO {

    private Long id;
    private CountryDTO country;
    @ApiModelProperty(value = "Date of the series")
    private Date date;
    @ApiModelProperty(value = "Total dosis administrated. Not equal to the number of people vaccinated")
    private Long totalVaccionations;
    @ApiModelProperty(value = "Number of people that received at least 1 dosis")
    private Long peopleVaccinated;
    @ApiModelProperty(value = "Number of people that received both dosis (if required)")
    private Long peopleFullyVaccinated;
    @ApiModelProperty(value = "Dosis administrated in this day. Not recommended (use dailyVaccinations instead)")
    private Long dailyVaccinationsRaw;
    @ApiModelProperty(value = "Dosis administrated taken into account not reported data and adjusting laking reports.")
    private Long dailyVaccionations;
    @ApiModelProperty(value = "total_vaccinations per 100 people in the total population of the country.")
    private Double totalVaccinationsPerHundred;
    @ApiModelProperty(value = "Percentage of people that received at least 1 dosis.")
    private Double peopleVaccinatedPerHundred;
    @ApiModelProperty(value = "Percentage of people that are fully vaccinated.")
    private Double fullyVaccinatedPerHundred;
    @ApiModelProperty(value = "daily_vaccinations per 1,000,000 people in the total population of the country.")
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
