package pract_lesson_.PolymorphismExercise;

public class HybridCar extends NewCar{
    private double avgKmPerLitre;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("HybridCar -> engine started");
        System.out.println("HybridCar -> cylinders running");
    }

    @Override
    public void drive() {
        System.out.println("HybridCar -> driving");
        runEngine();
    }
}
