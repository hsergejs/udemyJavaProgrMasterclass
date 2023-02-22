package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

import java.util.ArrayList;
import java.util.List;

public class InterfacesMain {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animalBird = bird;
        FlightEnabled flightEnabledBird = bird;
        Trackable trackableBird = bird;

        animalBird.move();

//        flightEnabledBird.takeOff();
//        flightEnabledBird.fly();
//        flightEnabledBird.land();
//
//        trackableBird.track();

        inFlight(flightEnabledBird);

        System.out.println("*".repeat(30));

        //!!!!passing Class with implemented interface FlightEnabled
        inFlight(new Jet());

        System.out.println("*".repeat(30));

        Trackable trackableTruck = new Truck();
        trackableTruck.track();

        System.out.println("*".repeat(30));

        double kmTraveled = 100;
        double milesTraveled = kmTraveled*FlightEnabled.KM_TO_MILES;
        System.out.printf("Truck traveled: %.2f km, which is %.2f miles%n", kmTraveled,milesTraveled);

        System.out.println("*".repeat(30));

        //it's a good code practice to use max level interface, e.g. List, instead of more specific, e.g. ArrayList<>()
        //in declaration
        List<FlightEnabled> flightEnabledUnits = new ArrayList<>();
        flightEnabledUnits.add(bird);
        System.out.println("Higher hierarchy level interface example");

        System.out.println("*".repeat(30));

        inFlightWithTransitionMethod(new Jet());

        System.out.println("*".repeat(30));

        //use of static method in interface
        //as toString isn't overridden for Satellite it will show default output for class
        OrbitEarth.log("Testing " + new Satellite());

        System.out.println("*".repeat(30));
        //use of private static method in OrbitEarth interface
        orbit(new Satellite());
    }

    //passing as a parameter implemented interface FlightEnabled
    private static void inFlight(FlightEnabled flightEnabled){
        flightEnabled.takeOff();
        flightEnabled.fly();

        //note that instanceof is checking interface not a class !!!!!!!!!!!!!
        if(flightEnabled instanceof Trackable isInstanceOfTrackable){
            isInstanceOfTrackable.track();
        }

        flightEnabled.land();
    }

    private static void inFlightWithTransitionMethod(FlightEnabled flightEnabled){
        flightEnabled.takeOff();
        flightEnabled.transition(FlightStages.LAUNCH);
        flightEnabled.fly();

        //note that instanceof is checking interface not a class !!!!!!!!!!!!!
        if(flightEnabled instanceof Trackable isInstanceOfTrackable){
            isInstanceOfTrackable.track();
        }

        flightEnabled.land();
    }

    //it's a good code practice to use max level interface, e.g. List, instead of more specific, e.g. ArrayList<>()
    //in declaration
    private static void triggerFliers (List<FlightEnabled> fliers){
        for(var flier : fliers){
            flier.takeOff();
        }
    }

    private static void flyFliers (List<FlightEnabled> fliers){
        for(var flier : fliers){
            flier.fly();
        }
    }

    private static void landFliers (List<FlightEnabled> fliers){
        for(var flier : fliers){
            flier.land();
        }
    }

    //use of private concrete method in interface
    private static void orbit(OrbitEarth orbitEarth){
        orbitEarth.takeOff();
        orbitEarth.fly();
        orbitEarth.land();
    }
}
