package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public class Bird extends Animal implements FlightEnabled,Trackable{

    @Override
    public void move() {
        System.out.println("Bird flaps wings!");
    }
}
