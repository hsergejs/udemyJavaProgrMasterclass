package pract_lesson_.CompositionChallengeExercise;

public class SmartKitchen {
    Refrigerator refrigerator;
    DishWasher dishWasher;
    CoffeeMaker coffeeMaker;

    public SmartKitchen() {
        this.refrigerator = new Refrigerator();
        this.dishWasher = new DishWasher();
        this.coffeeMaker = new CoffeeMaker();
    }

    public void addWater(){
        coffeeMaker.setHasWorkToDo(true);
    }

    public void pourMilk(){
        refrigerator.setHasWorkToDo(true);
    }

    public void loadDishwasher(){
        dishWasher.setHasWorkToDo(true);
    }

    public void setKitchenState(boolean refFlag, boolean dishWasherFlag, boolean coffeFlag){
        refrigerator.setHasWorkToDo(refFlag);
        dishWasher.setHasWorkToDo(dishWasherFlag);
        coffeeMaker.setHasWorkToDo(coffeFlag);
    }

    public void doKitchenWork(){
        refrigerator.orderFood();
        dishWasher.doDishes();
        coffeeMaker.brewCoffee();
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }
}
