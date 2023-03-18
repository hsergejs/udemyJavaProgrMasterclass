package pract_lesson_.GenericsChallenge.GenericsNew.Challenge;

import java.util.Arrays;

//same functionality as in Point, but for 2 dim array
abstract class Line implements Mappable {
    private double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for(var location : locations){
            this.locations[index++] = Mappable.stringToLatLong(location);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations(){
        return Arrays.deepToString(locations);
    }
}
