package pract_lesson_.GenericsChallenge.GenericsNew.Challenge;

public class GenericsNewChallengeMain {
    public static void main(String[] args) {
        var nationalParks = new Park[]{
                new Park("Yellowstone","44.4882,-110.5916")
        };

        Layer<Park> parkLayer = new Layer<>(nationalParks);
        parkLayer.addLocations(new Park("Grand Canyon","36.1085,-112.0965"));
        parkLayer.renderLayer();

        var nationalRivers = new River[]{
                new River("Mississippi","47.2160,-95.2348","29.1533,-89.2495","35.1556,-90.0659"),
                new River("Missouri","45.9239,-111.4983","38.8146,-90.1218")
        };

        Layer<River> riverLayer = new Layer<>(nationalRivers);
        riverLayer.addLocations(new River("Delaware","42.2026,-110.123","123.123,-321.321"));
        riverLayer.renderLayer();
    }
}
