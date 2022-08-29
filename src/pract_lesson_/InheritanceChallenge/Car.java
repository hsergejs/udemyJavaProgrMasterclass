package pract_lesson_.InheritanceChallenge;

public class Car extends Vehicle {
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManualGearBox;
    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManualGearBox) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManualGearBox = isManualGearBox;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Current Car gear changed to " + this.currentGear);
    }

    public void changeVelocity(int speed, int direction){
        System.out.println("Car changed speed to " + speed + " and direction to " + direction);
        move(speed,direction);
    }


}
