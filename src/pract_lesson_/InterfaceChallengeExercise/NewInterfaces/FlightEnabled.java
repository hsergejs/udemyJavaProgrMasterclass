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

    FlightStages transition(FlightStages stage);

}
