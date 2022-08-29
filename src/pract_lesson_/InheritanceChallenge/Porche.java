package pract_lesson_.InheritanceChallenge;

public class Porche extends Car {
    private int roadServiceMonths;

    public Porche(int roadServiceMonths) {
        super("Porche", "3,5 TD", 4, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    //rate is is difference between speed and current speed;
    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity == 0){
            stop();
            changeGear(1);
        }
        else if(newVelocity > 0 && newVelocity <= 10){
            changeGear(1);
        }
        else if(newVelocity > 10 && newVelocity <= 20){
            changeGear(2);
        }
        else if(newVelocity > 20 && newVelocity <= 30){
            changeGear(3);
        }
        else
            changeGear(4);

        if(newVelocity > 0){
            changeVelocity(newVelocity,getCurrentDirection());

        }

    }
}
