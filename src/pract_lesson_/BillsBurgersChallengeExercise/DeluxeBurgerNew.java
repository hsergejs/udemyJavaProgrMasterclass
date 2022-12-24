package pract_lesson_.BillsBurgersChallengeExercise;

public class DeluxeBurgerNew extends BurgerNew{
    private ItemNew deluxe1;
    private ItemNew deluxe2;

    public DeluxeBurgerNew(String name, double price) {
        super(name, price);
    }

    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        super.addToppings(extra1, extra2, extra3);
        deluxe1 = new ItemNew("TOPPING",extra4,0);
        deluxe2 = new ItemNew("TOPPING", extra5,0);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if(deluxe1 != null){
            deluxe1.printItem();
        }
        if(deluxe2 != null){
            deluxe2.printItem();
        }
    }

    @Override
    public double getExtraPrice(String toppingName) {
        return 0;
    }
}
