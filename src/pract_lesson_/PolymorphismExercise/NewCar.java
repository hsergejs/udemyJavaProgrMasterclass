package pract_lesson_.PolymorphismExercise;

public class NewCar {
    private String description;

    public NewCar(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.println("NewCar -> engine started");
    }

    public void drive(){
        System.out.println("NewCar -> driving");
        runEngine();
    }

    protected void runEngine(){
        System.out.printf("%s -> engine running %n", this.getClass().getSimpleName());
    }
}
