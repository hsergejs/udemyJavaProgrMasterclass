package pract_lesson_.PolymorphismExercise;

public class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders,name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " started engine";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " accelerated";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " braking";
    }
}
