package dh.covid.api.external_fetchers;

import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationsExternalFetcher extends ExternalFetcher {

    @Value("${owid.base_url}/vaccinations/vaccinations.csv")
    private String url;
    private HttpClient client = HttpClientBuilder.create().build();

    public List<VaccinationCSV> getItems() throws Exception {
        return this.getItems(url, VaccinationCSV.class);
    }
}
