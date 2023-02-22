package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public class Jet implements FlightEnabled, Trackable{
    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off!");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing!");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying!");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " coordinates are recorded!");
    }

    @Override
    public FlightStages transition(FlightStages stage) {
        // super in return show that it's calling default FlightEnable interface method
        //return FlightEnabled.super.transition(stage);
        System.out.println(getClass().getSimpleName() + " transitioning!");
        //required super in the middle, as it's interface and default concrete method,
        // error show, if not stated, that Object class has this method, as interface is not a class
        return FlightEnabled.super.transition(stage);
    }
}
