package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public class Bird extends Animal implements FlightEnabled,Trackable{
    //because not all Animals and Birds fly, and we don't want to track all of them, we implement interfaces
    // and not adding required methods an abstract class Animal or in subclass Bird and creating required methods there
    @Override
    public void move() {
        System.out.println("Bird flaps wings!");
    }

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
}
