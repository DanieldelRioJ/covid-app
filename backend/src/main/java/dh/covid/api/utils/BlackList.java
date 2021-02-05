package dh.covid.api.utils;

import java.util.ArrayList;
import java.util.List;

public class BlackList {
    private static final String[] bannedCountries
            = {"Gibraltar",
            "Seychelles",
            "Cayman Islands",
            "Isle of Man",
            "Guernsey",
            "Jersey",
            "Wales",
            "Scotland",
            "Faeroe Islands",
            "Greenland"
    };

    public static boolean inBlackList(String countryName){
        for(String bannedCountry: bannedCountries)
            if(bannedCountry.equalsIgnoreCase(countryName)) return true;

        return false;
    }
}
