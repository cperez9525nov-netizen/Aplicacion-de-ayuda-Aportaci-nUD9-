package App.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*** "API" simulada que lee facilities.txt y busca instalaciones dentro de un radio (km)***/
public class FacilityLocator {

    private final List<Facility> allFacilities = new ArrayList<>();
    private final String dataPath = "SRC/Resources/facilities.txt";

    public FacilityLocator() {
        loadFacilities();
    }

    private void loadFacilities() {
        File f = new File(dataPath);
        if (!f.exists()) {
            System.err.println("Warning: facilities.txt no encontrado en " + dataPath);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                // formato: tipo|nombre|latitud|longitud|info
                String[] p = line.split("\\|");
                if (p.length < 5) continue;
                String tipo = p[0].trim();
                String nombre = p[1].trim();
                double lat = Double.parseDouble(p[2].trim());
                double lon = Double.parseDouble(p[3].trim());
                String info = p[4].trim();
                allFacilities.add(new Facility(tipo, nombre, lat, lon, info));
            }
        } catch (Exception e) {
            System.err.println("Error leyendo facilities.txt: " + e.getMessage());
        }
    }

    /*** Busca instalaciones dentro de un radio (km) alrededor de lat,lon.***/
    public List<Facility> findNearby(double lat, double lon, double radiusKm) {
        List<Facility> result = new ArrayList<>();
        for (Facility facility : allFacilities) {
            double dist = haversine(lat, lon, facility.getLat(), facility.getLon());
            if (dist <= radiusKm) {
                result.add(facility);
            }
        }
        return result;
    }

    /*** Haversine (devuelve distancia en km entre dos coordenadas)***/
    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.0; // km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}