package dh.covid.api.controllers;

import dh.covid.api.services.CountryService;
import dh.covid.api.services.DataDumper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SitemapController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/sitemap.xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ApiOperation("Fetch data from online csvs and updates DB. ONLY FOR DEV USE")
    private ResponseEntity<?> testVaccines() throws Exception {

        List<String> countryNames = countryService.findAll().stream().map(country -> country.getName()).collect(Collectors.toList());
        Date today = new Date();
        String xml = "";
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xml += "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">";
        xml += "<url>\n" +
                "\n" +
                "      <loc>https://vaccine-covid.live/</loc>\n" +
                "\n" +
                "      <lastmod>"+simpleDateFormat.format(today)+"</lastmod>\n" +
                "\n" +
                "      <changefreq>daily</changefreq>\n" +
                "\n" +
                "      <priority>0.8</priority>\n" +
                "\n" +
                "   </url>";

        for(String country: countryNames){
            xml += "<url>\n" +
                    "\n" +
                    "      <loc>https://vaccine-covid.live/countries/"+country+"</loc>\n" +
                    "\n" +
                    "      <lastmod>"+simpleDateFormat.format(today)+"</lastmod>\n" +
                    "\n" +
                    "      <changefreq>daily</changefreq>\n" +
                    "\n" +
                    "      <priority>0.5</priority>\n" +
                    "\n" +
                    "   </url>\n";
        }
        xml += "</urlset> ";
        return ResponseEntity.ok(xml);
    }

}
