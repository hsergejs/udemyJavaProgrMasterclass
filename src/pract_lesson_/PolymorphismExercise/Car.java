package pract_lesson_.PolymorphismExercise;

public class Car {
    private String name;
    private int cylinders;
    private int wheels;
    private boolean engine;

    public Car(int cylinders, String name) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String startEngine() {
        return getClass().getSimpleName() + " started engine";
    }

    public String accelerate(){
        return getClass().getSimpleName() + " is accelerating";
    }

    public String brake(){
        return getClass().getSimpleName() + " is braking";
    }
}
