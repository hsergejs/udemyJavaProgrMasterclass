package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.*;

public class MainBillsBurger {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<Integer,Drink> drinkList = loadDrinkList();
        Map<Integer,SideItem> sideItemList = loadSideItemsList();
        Map<Integer,Topping> toppingList = loadToppingsList();
        do{
            String options = """
                    Please choose your option: 
                    Enter 1 to order Regular burger meal
                    Enter 2 to order Deluxe burger meal
                    Enter 3 to make your own burger meal
                    Enter q to quit""";
            System.out.printf("%s%n",options);
            try{
                int menuChoice = Integer.parseInt(scanner.nextLine());
                if(menuChoice == 1){
                    OrderItem orderItem = new OrderItem();
                    orderItem.addDrink(new Drink(drinkList.get(1).size(),drinkList.get(1).price()));
                    orderItem.addSideItem(new SideItem(sideItemList.get(1).name(),sideItemList.get(1).price()));
                    orderItem.addToppingItem(toppingList, 0);
                    orderItem.showOrder();
                    System.out.printf("Your order total is: %.2f",orderItem.getOrderTotal());
                    System.out.println("\n".repeat(1));
                }
                else if(menuChoice == 2 || menuChoice == 3){
                    System.out.println("Please choose your drink: ");
                    printChoiceMenu(drinkList);
                    int subMenuChoice = Integer.parseInt(scanner.nextLine());
                    if(subMenuChoice > 0 && subMenuChoice <= drinkList.size()){
                        Drink drink = new Drink(drinkList.get(subMenuChoice).size(),
                                drinkList.get(subMenuChoice).price());

                        System.out.println("Please choose your side item: ");
                        printChoiceMenu(sideItemList);
                        subMenuChoice = Integer.parseInt(scanner.nextLine());
                        if(subMenuChoice > 0 && subMenuChoice <= sideItemList.size()){
                            SideItem sideItem = new SideItem(sideItemList.get(subMenuChoice).name(),
                                    sideItemList.get(subMenuChoice).price());

                            OrderItem orderItem = (menuChoice == 2) ? new OrderItem(sideItem,drink) :
                                    (menuChoice == 3) ? new OrderItem(drink,sideItem) : null;

                            int toppingsCount = (menuChoice == 2) ? 5 : (menuChoice == 3) ? 3 : 0;

                            System.out.println("Please choose your toppings: ");
                            printChoiceMenu(toppingList);
                            orderItem.addToppingItem(toppingList,toppingsCount);
                            orderItem.showOrder();
                            System.out.printf("Your order total is: %.2f",orderItem.getOrderTotal());
                            System.out.println("\n".repeat(1));
                        }
                        else{
                            System.out.println("Not in menu, try again!");
                        }
                    }
                    else{
                        System.out.println("Not in menu, try again!");
                    }
                }
                else{
                    System.out.println("Not in menu, try again!");
                }

            }
            catch(NumberFormatException e){
                System.out.println("Exiting application");
                break;
            }
        }while(true);
    }

    private static void printChoiceMenu(Map<Integer,?> list){
        for(Map.Entry<Integer,?> listItem : list.entrySet()){
            System.out.printf("Press %d to add %s %n", listItem.getKey(), listItem.getValue());
        }
    }

    private static HashMap<Integer,Topping> loadToppingsList(){
        HashMap<Integer,Topping> tmpList = new HashMap<>();
        tmpList.put(1,new Topping("Lettuce",1.00));
        tmpList.put(2,new Topping("Sliced Tomatoes",1.50));
        tmpList.put(3,new Topping("Cheese",0.99));
        tmpList.put(4,new Topping("Bacon", 2.49));
        tmpList.put(5,new Topping("Extra sauce",0.50));
        tmpList.put(6,new Topping("Onion",1.19));
        return tmpList;
    }

    private static HashMap<Integer,SideItem> loadSideItemsList(){
        HashMap<Integer,SideItem> tmpList = new HashMap<>();
        tmpList.put(1,new SideItem("Fries", 4.99));
        tmpList.put(2,new SideItem("Fried onion rings", 3.99));
        tmpList.put(3,new SideItem("Chicken nuggets", 5.35));
        tmpList.put(4,new SideItem("Pancakes",5.99));
        tmpList.put(5,new SideItem("Ice cream", 1.00));
        return tmpList;
    }

    private static HashMap<Integer,Drink> loadDrinkList(){
        HashMap<Integer,Drink> tmpList = new HashMap<>();
        tmpList.put(1, new Drink("Small", 1.00));
        tmpList.put(2, new Drink("Medium", 1.20));
        tmpList.put(3, new Drink("Large", 1.50));
        return tmpList;
    }
}
