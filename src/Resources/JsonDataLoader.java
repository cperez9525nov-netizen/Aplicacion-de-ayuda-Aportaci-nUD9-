package Resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonDataLoader {
    public static List<CentersPOJO> loadCenters(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // ObjectMapper hace TODO el trabajo de lectura, split, trim y parseo por ti
            return mapper.readValue(new File(path), new TypeReference<List<CentersPOJO>>(){});
        } catch (Exception e) {
            System.out.println("Error leyendo JSON con Jackson: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}