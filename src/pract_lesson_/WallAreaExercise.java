package pract_lesson_;

//class name Wall
public class WallAreaExercise {
    private double width;
    private double height;

    public WallAreaExercise(){

    }

    public WallAreaExercise(double width, double height) {
        if(width < 0){
            this.width = 0.0;
        }
        else
            this.width = width;

        if(height < 0){
            this.height = 0.0;
        }
        else
            this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width<0){
            this.width = 0.0;
        }
        else
            this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height<0){
            this.height = 0.0;
        }
        else
            this.height = height;
    }

    public double getArea(){
        return this.height*this.width;
    }
}
