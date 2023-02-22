package pract_lesson_.InterfaceChallengeExercise.NewInterfaces;

public interface TestExtends extends Trackable,OrbitEarth{
    //you can choose as a developer, which methods to override, when interface extend other interface
    //if override from DEFAULT method in parent interface use super in middle

    @Override
    default FlightStages transition(FlightStages stage) {
        return OrbitEarth.super.transition(stage);
    }
}
