package pract_lesson_.CompositionChallengeExercise;

public class Refrigerator {
    private boolean hasWorkToDo;

    public Refrigerator() {
        this.hasWorkToDo = false;
    }

    public void orderFood(){
        if(hasWorkToDo){
            System.out.println("Fridge is ordering food");
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
