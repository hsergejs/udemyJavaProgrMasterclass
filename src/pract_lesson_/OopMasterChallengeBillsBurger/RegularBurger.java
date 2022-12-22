package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.HashMap;
import java.util.Map;

final class RegularBurger extends Burger{
    public RegularBurger(String name, double price) {
        super(name, price);
    }

    @Override
    public void addToppings(Map<Integer, ?> toppingList, int toppingsCounter) {
        HashMap<Integer,Topping> newToppingList = (HashMap<Integer, Topping>) new HashMap<>(toppingList);
        toppings.add(newToppingList.get(1));
        toppings.add(newToppingList.get(2));
        toppings.add(newToppingList.get(3));
    }
}
