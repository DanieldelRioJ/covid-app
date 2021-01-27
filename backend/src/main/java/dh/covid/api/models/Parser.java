package dh.covid.api.models;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.List;

//Automatic generic parser
@Component
public class Parser{

    public <T> List<T> parse(String content, Class<T> classNeeded){
        List<T> beans = new CsvToBeanBuilder(new StringReader(content))
                .withType(classNeeded)
                .build()
                .parse();

        return beans;
    }
}
