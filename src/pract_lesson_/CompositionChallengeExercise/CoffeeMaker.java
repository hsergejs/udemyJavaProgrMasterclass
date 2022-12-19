package pract_lesson_.CompositionChallengeExercise;

public class CoffeeMaker {
    private boolean hasWorkToDo;

    public CoffeeMaker() {
        this.hasWorkToDo = false;
    }

    public void brewCoffee(){
        if(hasWorkToDo){
            System.out.println("Coffee maker brewing coffee");
            hasWorkToDo = false;
        }
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}
