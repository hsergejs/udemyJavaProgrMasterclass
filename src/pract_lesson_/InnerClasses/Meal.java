package pract_lesson_.InnerClasses;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private double base = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate){
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke","drink",1.5);
        side = new Item("fries","side",2.0);
        //example of direct access of the parent class to the attributes of the inner class
        System.out.println(drink.name);
    }

    public double getTotal(){
        //we can access getPrice, as Item -> Burger is a subclass of the Meal class
        double total = burger.getPrice() + drink.price + side.price;
        //example of accessing static method in inner class from parent class
        return Item.conversionGetPrice(total,conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%27s$%.2f".formatted(burger,drink,side,"Total due: ",getTotal());
    }

    public void addToppings(String... toppings){
        burger.addToppings(toppings);
    }

    private class Item{
        private String name;
        private String type;
        private double price;

        //example of assignment of the field directly in nested child class of the value from
        // the private field of the parent class
        public Item(String name, String type) {
            this(name,type,type.equals("burger") ? base : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s,%15s $%.2f".formatted(name,type,conversionGetPrice(price,conversionRate));
        }

        private static double conversionGetPrice(double price, double rate){
            return price*rate;
        }
    }

    private class Burger extends Item{
        private List<Item> toppings = new ArrayList<>();
        //before JDK16 it was not available, as no static members, except static constants in inner class were allowed
        // all enums, records and interfaces are implicitly static when declared in inner classes
        private static enum Extra{BACON,CHEESE,KETCHUP,MAYO,MUSTARD,PICKLES;
            private double getPrice(){
                return switch (this){
                    case CHEESE,PICKLES -> 1.5;
                    case KETCHUP -> 1.12;
                    case MAYO,MUSTARD -> 1.15;
                    default -> 0.00;
                };
            }
        }
        Burger(String name) {
            super(name, "burger", 5.00);
        }

        //as Item is inner class of Meal and Burger extends Item, we can access private fields directly
        public double getPrice(){
            double total = super.price;
            for(Item topping : toppings){
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String... selectedToppings){
            for(String selectedTopping : selectedToppings){
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(), "TOPPING", topping.getPrice()));
                }
                catch(IllegalArgumentException e){
                    System.out.println("Topping: " + selectedTopping + " not available");
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(super.toString());
            for(Item topping : toppings){
                builder.append("\n");
                builder.append(topping);
            }
            return builder.toString();
        }
    }
}
