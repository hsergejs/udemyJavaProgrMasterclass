package pract_lesson_.SetsHashSetLectureChallengeExercise;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satelites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satelites.add(moon);
    }

    //Override not Overload method !!!!!!!!!!! Overriding equals method for objects comparison,
    // required to override hashcode as well
    //if expected inherited (extending) object is a different type of object use this
    // approach of equals method override!!!!!
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    //if expected inherited (extending) object is a different type of object use this
    // approach  of equals method override!!!!! to meet symmetric comparison with subclass, implement equals at parent
    //object and mark it final, so inherited subclass can't override it, as it will show opposite results
    //e.g. our labrador is a dog, but dog is not our labrador
//    @Override
//    public final boolean equals(Object obj){
//        if(this == obj){
//            return true;
//        }
//
//        if(obj instanceof HeavenlyBody){
//            String objName = ((HeavenlyBody) obj).getName();
//            return this.name.equals(objName);
//        }
//
//        return false;
//    }


    @Override
    public final int hashCode() { //as equals is final and thus hashcode as well, to get symmetric result
        return this.name.hashCode() + 57;
    }
}
