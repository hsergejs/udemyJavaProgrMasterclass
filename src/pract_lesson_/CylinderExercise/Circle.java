package pract_lesson_.CylinderExercise;

public class Circle {
    private double radius;

    public Circle(double radius) {
        if(radius < 0){
            radius = 0;
        }
        else
            this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
}
