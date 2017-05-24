package dw;
public class WeatherJson {
    public static class Coord {
        public double lon;
        public double lat;
    }
    public static class Weather1 {
        public int id;
        public String main;
        public String description;
        public String icon;
    }
    public static class Wind {
        public double speed;
        public double deg;
    }
    public static class Clouds {
        public int all;
    }
    public static class Sys {
        public int type;
        public int id;
        public double message;
        public String country;
        public int sunrise;
        public int sunset;
    }
    public static class Main1 {
        public double temp;
        public int pressure;
        public int humidity;
        public double temp_min;
        public double temp_max;
    }
        
    public Coord    coord;
    public Weather1[]  weather;
    public String    base;
    public Main1     main;
    public Wind     wind;
    public Clouds   clouds;
    public int      dt;
    public Sys      sys;
    public int      id;
    public String   name;
    public int      cod;
}
 