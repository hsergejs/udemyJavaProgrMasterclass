package pract_lesson_.SetsHashSetLectureChallengeExercise;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBodyExercise {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBodyExercise> satellites;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public HeavenlyBodyExercise(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name,bodyType); //even it's constructor is private, as it's inner class
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return this.key;
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name,bodyType);
    }

    public Set<HeavenlyBodyExercise> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addSatellite(HeavenlyBodyExercise satellite){
        return this.satellites.add(satellite);
    }

    @Override
    public final boolean equals(Object obj){ //final to make it symmetric
        if(this == obj){
            return true;
        }

        if(obj instanceof HeavenlyBodyExercise){
            HeavenlyBodyExercise object = (HeavenlyBodyExercise) obj; //casting an object to use it further
            return this.key.equals(object.getKey());
        }

        return false;
    }

    @Override
    public final int hashCode() { //as equals is final and thus hashcode as well, to get symmetric result
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    //as it's tight with parent class, so it can be set to static
    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){
                return this.bodyType == key.getBodyType();
            }

            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
