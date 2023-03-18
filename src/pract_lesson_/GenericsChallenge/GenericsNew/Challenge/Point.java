package pract_lesson_.GenericsChallenge.GenericsNew.Challenge;

import java.util.Arrays;

abstract class Point implements Mappable {
    private double[] location = new double[2];
    //since Mappable method render() is abstract by default and Point is abstract, it's not obligate to implement it here,
    // but any class that will extend Point has to implement it, if it's not implemented in Point class
    // in this example it will be implemented here


    public Point(String location) {
        this.location = Mappable.stringToLatLong(location);
    }

    @Override
    public void render() {
        //THIS keyword will show String representation of the class
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location(){
        //will print array
        return Arrays.toString(location);
    }
}
