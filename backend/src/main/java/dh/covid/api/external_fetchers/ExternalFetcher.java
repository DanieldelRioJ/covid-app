package dh.covid.api.external_fetchers;

import dh.covid.api.models.Parser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExternalFetcher{

    @Autowired
    private Parser parser;

    private HttpClient client = HttpClientBuilder.create().build();

    public <T> List<T> getItems(String url, Class<T> classNeeded) throws Exception{
        //Fetch csv
        HttpResponse response = null;
        response = client.execute(new HttpGet(url));
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);

        List<T> data= parser.parse(content, classNeeded);
        return data;
    }
}
