package dh.covid.api.models.country;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvCustomBindByPosition;
import dh.covid.api.utils.LocalDateConverter;

import java.time.LocalDate;
import java.util.Date;

public class VaccinationData {
    @CsvBindByName(column = "location")
    private String countryName;

    @CsvBindByName(column = "iso_code")
    private String countryISO;

    @CsvCustomBindByName(column = "date", converter = LocalDateConverter.class)
    private LocalDate date;

    @CsvBindByName(column = "total_vaccinations")
    private Long totalVaccionations;

    @CsvBindByName(column = "people_vaccinated")
    private Long peopleVaccinated;

    @CsvBindByName(column = "people_fully_vaccinated")
    private Long peopleFullyVaccinated;

    @CsvBindByName(column = "daily_vaccinations_raw")
    private Long dailyVaccinationsRaw;

    @CsvBindByName(column = "daily_vaccinations")
    private Long dailyVaccionations;

    @CsvBindByName(column = "total_vaccinations_per_hundred")
    private Double totalVaccinationsPerHundred;

    @CsvBindByName(column = "people_vaccinated_per_hundred")
    private Double peopleVaccinatedPerHundred;

    @CsvBindByName(column = "people_fully_vaccinated_per_hundred")
    private Double fullyVaccinatedPerHundred;

    @CsvBindByName(column = "daily_vaccinations_per_million")
    private Long dailyVaccionationsPerMillion;

    public VaccinationData(){

    }

    public VaccinationData(LocalDate date, Long totalVaccionations, Long peopleVaccinated, Long peopleFullyVaccinated,
                           Long dailyVaccinationsRaw, Long dailyVaccionations, Double totalVaccinationsPerHundred,
                           Double peopleVaccinatedPerHundred, Double fullyVaccinatedPerHundred, Long dailyVaccionationsPerMillion) {
        this.date = date;
        this.totalVaccionations = totalVaccionations;
        this.peopleVaccinated = peopleVaccinated;
        this.peopleFullyVaccinated = peopleFullyVaccinated;
        this.dailyVaccinationsRaw = dailyVaccinationsRaw;
        this.dailyVaccionations = dailyVaccionations;
        this.totalVaccinationsPerHundred = totalVaccinationsPerHundred;
        this.peopleVaccinatedPerHundred = peopleVaccinatedPerHundred;
        this.fullyVaccinatedPerHundred = fullyVaccinatedPerHundred;
        this.dailyVaccionationsPerMillion = dailyVaccionationsPerMillion;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
