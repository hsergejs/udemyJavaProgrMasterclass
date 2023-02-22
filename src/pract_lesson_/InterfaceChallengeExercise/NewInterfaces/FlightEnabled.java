package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public interface FlightEnabled {
    //any field is declares is a constant, implicitly added public static final, and modifiers are redundant
    // thus not instance field
    public static final double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    //public modifier and abstract type implicitly declared for interface
    public abstract void takeOff();
    void land();
    void fly();

    //since jdk 8 default method introduced (or extension method), this allows to add method,
    // and it won't affect previous code, if it's not overridden, if so it will print stated msg bellow
    //it's a common practice to print not implemented interface on classes, or throw an exception
    // as example we pass Enum type as a parameter, with implemented interface Trackable
    default FlightStages transition(FlightStages stage) {
//        System.out.println("transition method not implemented in next classes: " + getClass().getName());
//        return null;

        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from (in FlightEnabled) " + stage + " to " + nextStage);
        return nextStage;
    }

}
