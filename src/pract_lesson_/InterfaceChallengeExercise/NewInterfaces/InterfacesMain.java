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

        inFlight(new Jet());

        System.out.println("*".repeat(30));

        Trackable trackableTruck = new Truck();
        trackableTruck.track();

        System.out.println("*".repeat(30));

        double kmTraveled = 100;
        double milesTraveled = kmTraveled*FlightEnabled.KM_TO_MILES;
        System.out.printf("Truck traveled: %.2f km, which is %.2f miles%n", kmTraveled,milesTraveled);

        System.out.println("*".repeat(30));

        List<FlightEnabled> flightEnabledUnits = new ArrayList<>();
        flightEnabledUnits.add(bird);


    }

    private static void inFlight(FlightEnabled flightEnabled){
        flightEnabled.takeOff();
        flightEnabled.fly();

        //note that instanceof is checking interface not a class !!!!!!!!!!!!!
        if(flightEnabled instanceof Trackable isInstanceOfTrackable){
            isInstanceOfTrackable.track();
        }

        flightEnabled.land();
    }

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
}
