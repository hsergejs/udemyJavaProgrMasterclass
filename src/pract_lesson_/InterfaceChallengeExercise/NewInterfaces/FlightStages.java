package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public enum FlightStages implements Trackable {
    GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }
}
