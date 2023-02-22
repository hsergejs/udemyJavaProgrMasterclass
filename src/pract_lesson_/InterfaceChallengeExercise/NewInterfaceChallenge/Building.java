package pract_lesson_.InterfaceChallengeExercise.NewInterfaceChallenge;

public class Building implements Mappable{
    private String name;
    private UsageType usageType;

    public Building(String name, UsageType usageType) {
        this.name = name;
        this.usageType = usageType;
    }

    @Override
    public String getLable() {
        return name + " (" + usageType + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usageType){
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarker.SQUARE;
            case SPORT -> Color.ORANGE + " " + PointMarker.PUSH_PIN;
            default -> Color.BLACK + " " + PointMarker.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name,usageType);
    }
}
