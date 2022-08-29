package pract_lesson_.SetsHashSetLectureChallengeExercise;

public class Planet extends HeavenlyBodyExercise {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBodyExercise satelite) {
        if(satelite.getKey().getBodyType() == BodyTypes.MOON){
            return super.addSatellite(satelite);
        }

        return false;
    }
}
