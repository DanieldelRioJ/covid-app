package dh.covid.api.external_fetchers;

import dh.covid.api.models.locations.LocationData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsExternalFetcher extends ExternalFetcher {

    @Value("${owid.base_url}/vaccinations/locations.csv")
    private String url;

    public List<LocationData> getItems() throws Exception {
        return this.getItems(url, LocationData.class);
    }
}
