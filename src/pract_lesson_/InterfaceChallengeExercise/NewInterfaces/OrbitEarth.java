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
    private static void logPrivate(String description){
        var today = new Date();
        System.out.println(today + " : " + description);
    }
}
