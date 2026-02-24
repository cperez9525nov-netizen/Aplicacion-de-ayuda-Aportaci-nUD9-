package Resources;

public class CentersPOJO {
    private String name;
    private String type;
    private double latitude;
    private double longitude;

    //Constructor vacío

    public CentersPOJO() {}

    //métodos getters

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    //métodos setters

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    //Creamos el método toString para que sobreescriba la lectura en Main y saber si imprime bien

    @Override
    public String toString() {
        return "CentersPOJO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
