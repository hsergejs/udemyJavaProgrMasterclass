package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.ArrayList;

final class DeluxeBurger extends Burger{
    public DeluxeBurger(String name, double price) {
        super(name, price);
        this.toppings = new ArrayList<>();
    }

    @Override
    public double calculateBurgerTotal() {
        return getPrice();
    }
}
