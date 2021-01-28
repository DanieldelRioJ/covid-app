package dh.covid.api.external_fetchers;

import dh.covid.api.models.external.locations.LocationCSV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsExternalFetcher extends ExternalFetcher {

    @Value("${owid.base_url}/vaccinations/locations.csv")
    private String url;

    public List<LocationCSV> getItems() throws Exception {
        return this.getItems(url, LocationCSV.class);
    }
}
