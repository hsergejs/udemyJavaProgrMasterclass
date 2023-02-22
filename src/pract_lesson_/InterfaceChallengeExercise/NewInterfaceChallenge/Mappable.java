package pract_lesson_.InterfaceChallengeExercise.NewInterfaceChallenge;

public interface Mappable {
    String JSON_PROPERTY = """
            "properties" : {%s} """; //specifier for formatted string

    String getLable();
    Geometry getShape();
    String getMarker();

    default String toJSON(){
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getShape(),getLable(),getMarker());
        //we call abstract methods from default method - getLabel() etc
    }

    static void mapIp(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
