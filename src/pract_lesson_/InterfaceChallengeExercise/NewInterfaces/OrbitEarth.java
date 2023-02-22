package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

import java.util.Date;


//!!!!! interface extends interface !!!!!!!!!!!
// but interface can't implement interface
public interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    //since jdk 8 we can use public static methods in interfaces
    //allow to add helper methods on interface itself, instead of using package helper class
    //public - is redundant, as all methods in interface are public
    static void log(String description){
        var today = new Date();
        System.out.println(today + " : " + description);
    }

    //since JDK 9 we can use private static and non-static methods on interfaces
    //and it can use only internal concrete methods in interface
    //for supporting default methods with shared common code
    private static void logPrivate(String description){
        var today = new Date();
        System.out.println(today + " : " + description);
    }

    //private non-static helper method
    private void logStage(FlightStages stage, String description){
        description = stage + " : " + description;
        //we can use only private method, from another method or default method
        logPrivate(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage =  FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition (in OrbitEarth) to " + nextStage);
        return nextStage;
    }
}
