package pract_lesson_.PolymorphismExercise;

public class GasPoweredCar extends NewCar{
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("GasPoweredCar -> engine started");
    }

    @Override
    public void drive() {
        System.out.println("GasPoweredCar -> driving");
        runEngine();
    }
}
