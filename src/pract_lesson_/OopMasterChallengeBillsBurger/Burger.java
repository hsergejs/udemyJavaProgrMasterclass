package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static pract_lesson_.OopMasterChallengeBillsBurger.MainBillsBurger.scanner;

class Burger {
    private String name;
    private double price;
    protected ArrayList<Topping> toppings;

    public Burger(String name, double price) {
        this.name = name;
        this.price = price;
        toppings = new ArrayList<>();
    }

    public void addToppings(Map<Integer,?> toppingList, int toppingsCounter){
        HashMap<Integer,Topping> newToppingList = (HashMap<Integer, Topping>) new HashMap<>(toppingList);
        int printCounter = toppingsCounter;
        while(toppings.size() != toppingsCounter){
            try{
                int menuChoice = Integer.parseInt(scanner.nextLine());
                if(menuChoice > 0 && menuChoice <= newToppingList.size()){
                    toppings.add(newToppingList.get(menuChoice));
                    printCounter--;
                    System.out.println("Added " + newToppingList.get(menuChoice).name() + " to your burger");
                    System.out.println("Toppings left to add: " + printCounter);
                }
                else{
                    System.out.println("Not in menu, try again!");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Not in menu, try again!");
            }
        }
    }

    public double calculateBurgerTotal(){
        double total = this.price;
        for(Topping topping : toppings){
            total += topping.price();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
}


