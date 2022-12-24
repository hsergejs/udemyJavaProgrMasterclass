package pract_lesson_.BillsBurgersChallengeExercise;

public class MealOrderNew {
    private BurgerNew burgerNew;
    private ItemNew drink;
    private ItemNew side;

    public MealOrderNew(){
        this("regular","coke","fries");
    }

    public MealOrderNew(String burgerType, String drinkType, String sideType){
        if(burgerType.equalsIgnoreCase("deluxe")){
            this.burgerNew = new DeluxeBurgerNew(burgerType,8.5);
        }
        else {
            this.burgerNew = new BurgerNew(burgerType, 4.0);
        }
        this.drink = new ItemNew("drink", drinkType, 1.00);
        this.side = new ItemNew("side", sideType, 1.50);
    }

    public double getTotalPrice(){
        if(burgerNew instanceof DeluxeBurgerNew){ //if ordered deluxe burger
            return burgerNew.getAdjustedPrice(); //total doesn't include drink or side
        }

        return side.getAdjustedPrice() + drink.getAdjustedPrice() + burgerNew.getAdjustedPrice();
    }

    public void printItemizedList(){
        burgerNew.printItem();
        if(burgerNew instanceof DeluxeBurgerNew){
            ItemNew.printItem(drink.getName(), 0);
            ItemNew.printItem(side.getName(), 0);
        }
        else{
            drink.printItem();
            side.printItem();
        }
        System.out.println("-".repeat(20));
        ItemNew.printItem("Total price: ",getTotalPrice());

    }

    public void addBurgerToppings(String extra1, String extra2, String extra3){
        burgerNew.addToppings(extra1,extra2,extra3);
    }

    public void addBurgerToppings(String extra1, String extra2, String extra3, String extra4, String extra5){
        if(burgerNew instanceof DeluxeBurgerNew deluxeBurger){ //otherwise required casting to DeluxeBurgerNew
            deluxeBurger.addToppings(extra1,extra2,extra3,extra4,extra5);
        }
        else{
            burgerNew.addToppings(extra1,extra2,extra3);
        }
    }

    public void setDrinkSize(String size){
        drink.setSize(size);
    }


}
