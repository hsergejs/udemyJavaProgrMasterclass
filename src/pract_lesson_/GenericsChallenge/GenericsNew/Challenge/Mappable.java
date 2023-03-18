package pract_lesson_.GenericsChallenge.GenericsNew.Challenge;

public interface Mappable {
    void render();
    static double[] stringToLatLong(String location){
        var splitString = location.split(",");
        double lat = Double.valueOf(splitString[0]);
        double longt = Double.parseDouble(splitString[1]);
        return new double[]{lat,longt};
    }
}
