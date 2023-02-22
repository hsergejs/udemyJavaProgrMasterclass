package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public class Satellite implements OrbitEarth{

    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void takeOff() {
        transition("Satellite Taking Off!");
    }

    @Override
    public void land() {
        transition("Satellite Landing!");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection while Satellite Orbiting!");
    }

    @Override
    public void achieveOrbit() {
        transition("Orbit is achieved!");
    }

    //overloading method, not overriding in OrbitEarth interface
    private void transition(String description){
        System.out.println(description);
        //method from OrbitEarth
        stage = transition(stage);
        stage.track();
    }
}
