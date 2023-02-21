package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public class InterfacesMain {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flightEnabled = bird;
        Trackable trackable = bird;

        animal.move();
    }
}
