package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public enum FlightStages implements Trackable {
    GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values(); //get all stages in array
        //in example allStages[3] index values, passed LAUNCH - 1
        //allStages[1+1%4] - all ordinal()+1 values up to 4 % 4 will return ordinal()+1 value
        //also true for all ordinal()+1 values up to allStages.length % allStages.length will return ordinal()+1 value
        //which is a next value
        System.out.println("next value in allStages[] " + (1+1)%4);
        return allStages[(ordinal() +1) % allStages.length]; //to avoid use of GROUNDED, LAUNCH etc, e.g. specific values

    }
}
