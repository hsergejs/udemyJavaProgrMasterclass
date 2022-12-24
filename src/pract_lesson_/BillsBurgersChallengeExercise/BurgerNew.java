package pract_lesson_.BillsBurgersChallengeExercise;

public class BurgerNew extends ItemNew {
    private ItemNew extra1,extra2,extra3;

    public BurgerNew(String name, double price) {
        super("Burger", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingName){
        return switch(toppingName){
            case "AVOCADO","CHEESE" -> 1.00;
            case "BACON","HAM","SALAMI" -> 1.50;
            default -> 0.00;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3){
        this.extra1 = new ItemNew("TOPPING", extra1,getExtraPrice(extra1));
        this.extra2 = new ItemNew("TOPPING", extra2,getExtraPrice(extra2));
        this.extra3 = new ItemNew("TOPPING", extra3,getExtraPrice(extra3));
    }

    public void printItemizedList(){
        printItem("BASE BURGER", getBasePrice());
        if(extra1 != null){
            extra1.printItem(); //as topping is item, we can reuse method;
        }
        if(extra2 != null){
            extra2.printItem(); //as topping is item, we can reuse method;
        }
        if(extra3 != null){
            extra3.printItem(); //as topping is item, we can reuse method;
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(20));
        super.printItem();
    }


}
