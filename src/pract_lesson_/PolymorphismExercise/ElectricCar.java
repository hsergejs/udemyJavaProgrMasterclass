package pract_lesson_.PolymorphismExercise;

public class ElectricCar extends NewCar{
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.println("ElectricCar -> engine started");
    }

    @Override
    public void drive() {
        System.out.println("ElectricCar -> driving");
        runEngine();
    }
}
