package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.Map;

class OrderItem {
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;
    private double totalPrice;

    public OrderItem(){
        burger = new RegularBurger("Hamburger", 3.99);
    }

    public OrderItem(SideItem sideItem, Drink drink){
        burger = new DeluxeBurger("Deluxe burger",15.99);
        addSideItem(sideItem);
        addDrink(drink);
    }

    public OrderItem(Drink drink, SideItem sideItem){
        burger = new Burger("Custom burger", 4.99);
        addDrink(drink);
        addSideItem(sideItem);
    }

    public void addToppingItem(Map<Integer,?> toppingList, int toppingsCounter){
        burger.addToppings(toppingList, toppingsCounter);
    }

    public void addDrink(Drink drink){
        this.drink = drink;
    }

    public void addSideItem(SideItem sideItem){
        this.sideItem = sideItem;
    }

    public double getOrderTotal(){
        return this.totalPrice += burger.calculateBurgerTotal() + drink.price() + sideItem.price();
    }

    public void showOrder(){
        System.out.print("-".repeat(10));
        System.out.print(" Your order ");
        System.out.print("-".repeat(10));
        System.out.printf("%nBurger: %s \t price: %.2f%n", burger.getName(), burger.getPrice());
        System.out.println("Burger toppings: ");
        for(Topping topping : burger.getToppings()){
            System.out.printf("\t %s \t price: %.2f %n", topping.name(), topping.price());
        }
        System.out.printf("Side item: %s \t price: %.2f %n",sideItem.name(),sideItem.price());
        System.out.printf("Drink size: %s \t price: %.2f %n",drink.size(),drink.price());
    }
}
