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

    public OrderItem(String drinkName, String drinkSize, double drinkPrice, String sideName, String sideSize, double sidePrice){
        burger = new DeluxeBurger("Deluxe burger",20.00);
        addDrink(drinkName,drinkSize,drinkPrice);
        addSideItem(sideName,sideSize,sidePrice);
    }

    public OrderItem(String burgerName, String drinkName, String drinkSize, double drinkPrice, String sideName, String sideSize, double sidePrice){
        burger = new Burger(burgerName, 4.99);
        addDrink(drinkName,drinkSize,drinkPrice);
        addSideItem(sideName,sideSize,sidePrice);
    }

    public void addToppingItem(Map<Integer,?> toppingList, int toppingsCounter){
        burger.addToppings(toppingList, toppingsCounter);
    }

    public void addDrink(String name, String size, double price){
        this.drink = new Drink(name,price);
        drink.setSize(size);
    }

    public void addSideItem(String name, String size, double price){
        this.sideItem = new SideItem(name,price);
        sideItem.setSize(size);
    }

    public double getOrderTotal(String drinkSize, String sideSize){
        if(burger instanceof DeluxeBurger){
            return totalPrice = burger.getPrice();
        }
        else{
            return totalPrice += burger.calculateBurgerTotal() + drink.getAdjustedPrice(drinkSize)
                    + sideItem.getAdjustedPrice(sideSize);
        }
    }

    public void showOrder(){
        System.out.print("*".repeat(15));
        System.out.printf(" %s ","Your order".toUpperCase());
        System.out.println("*".repeat(15));
        System.out.printf("%25s : %6.2f%n%n",burger.getName().toUpperCase(), burger.getPrice());

        if(burger instanceof DeluxeBurger){
            burger.printToppings();
            System.out.println();
            System.out.printf("%17s %7s : %6.2f %n",sideItem.getName().toUpperCase(),
                    sideItem.getSize().toUpperCase(),
                    0.00);
            System.out.printf("%17s %7s : %6.2f %n",drink.getName().toUpperCase(),
                    drink.getSize().toUpperCase(),
                    0.00);
        }
        else{
            burger.printToppings();
            System.out.println();
            System.out.printf("%17s %7s : %6.2f %n",sideItem.getName().toUpperCase(),
                    sideItem.getSize().toUpperCase(),
                    sideItem.getAdjustedPrice(sideItem.getSize()));
            System.out.printf("%17s %7s : %6.2f %n",drink.getName().toUpperCase(),
                    drink.getSize().toUpperCase(),
                    drink.getAdjustedPrice(drink.getSize()));
        }
        System.out.println("-".repeat(42));
        System.out.printf("%25s : %6.2f%n","Total".toUpperCase(),getOrderTotal(drink.getSize(),sideItem.getSize()));
        System.out.println("*".repeat(42));
    }
}
