package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public class Truck implements Trackable{
    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " coordinates are recorded!");
    }
}
