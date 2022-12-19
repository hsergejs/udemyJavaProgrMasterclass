package pract_lesson_.CompositionChallengeExercise;

public class DishWasher {
    private boolean hasWorkToDo;

    public DishWasher() {
        this.hasWorkToDo = false;
    }

    public void doDishes(){
        if(hasWorkToDo){
            System.out.println("Dishwasher doing dishes");
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
