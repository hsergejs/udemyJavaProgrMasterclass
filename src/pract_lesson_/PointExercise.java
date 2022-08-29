package pract_lesson_;

//class name Point
public class PointExercise {
    private int x;
    private int y;

    public PointExercise(){

    }

    public PointExercise(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        //distance between this.Point and Point(0.0,0.0);
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    public double distance(int x, int y){
        //distance between this.Point and Point(x,y)
        return Math.sqrt(((x-this.x)*(x-this.x))+((y-this.y)*(y-this.y)));
    }

    public double distance(PointExercise p){
        double x = p.getX();
        double y = p.getY();
        return Math.sqrt(((x-this.x)*(x-this.x))+((y-this.y)*(y-this.y)));
    }
}
