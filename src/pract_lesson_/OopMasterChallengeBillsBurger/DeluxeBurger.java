package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.ArrayList;

final class DeluxeBurger extends Burger{
    public DeluxeBurger(String name, double price) {
        super(name, price);
        this.toppings = new ArrayList<>();
    }

    @Override
    public double calculateBurgerTotal() {
        return super.getPrice();
    }

    @Override
    public void printToppings() {
        for(Topping topping : getToppings()){
            System.out.printf("%25s : %6.2f%n", topping.name().toUpperCase(),0.00);
        }
    }
}
