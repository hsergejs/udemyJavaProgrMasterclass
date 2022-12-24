package pract_lesson_.OopMasterChallengeBillsBurger;

import java.util.*;

public class MainBillsBurger {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<Integer,Drink> drinkList = loadDrinkList();
        Map<Integer,String> sizeList = loadSizeList();
        Map<Integer,SideItem> sideItemList = loadSideItemsList();
        Map<Integer,Topping> toppingList = loadToppingsList();
        int []menuChoiceList = new int[5];
        do{
            String options = """
                    Please choose your option:
                    Enter 1 to order Regular burger meal
                    Enter 2 to order Deluxe burger meal
                    Enter 3 to make your own burger meal
                    Enter q to quit""";
            System.out.printf("%s%n",options);
            try{
                menuChoiceList[0] = Integer.parseInt(scanner.nextLine());
                int toppingsCount = (menuChoiceList[0] == 2) ? 5 : (menuChoiceList[0] == 3) ? 3 : 0;
                if(menuChoiceList[0] == 1){
                    menuChoiceList[1] = 1; //drink name
                    menuChoiceList[2] = 2; //drink size
                    menuChoiceList[3] = 1; //side name
                    menuChoiceList[4] = 1; //side size
                    OrderItem orderItem = new OrderItem();
                    orderItem.addDrink(drinkList.get(menuChoiceList[1]).getName(),sizeList.get(menuChoiceList[2]),
                            drinkList.get(menuChoiceList[1]).getPrice());
                    orderItem.addSideItem(sideItemList.get(menuChoiceList[3]).getName(),sizeList.get(menuChoiceList[4]),
                            sideItemList.get(menuChoiceList[3]).getPrice());
                    orderItem.addToppingItem(toppingList, toppingsCount);
                    orderItem.showOrder();
                    System.out.println("\n".repeat(1));
                }
                else if(menuChoiceList[0] == 2 || menuChoiceList[0] == 3){
                    System.out.println("Please choose your drink: ");
                    printChoiceMenu(drinkList);
                    menuChoiceList[1] = Integer.parseInt(scanner.nextLine());
                    if(menuChoiceList[1] > 0 && menuChoiceList[1] <= drinkList.size()){
                        System.out.println("Please choose your drink size: ");
                        printChoiceMenu(sizeList);
                        menuChoiceList[2] = Integer.parseInt(scanner.nextLine());
                        if(menuChoiceList[2] > 0 && menuChoiceList[2] <= sizeList.size()){
                            System.out.println("Please choose your side item: ");
                            printChoiceMenu(sideItemList);
                            menuChoiceList[3] = Integer.parseInt(scanner.nextLine());
                            if(menuChoiceList[3] > 0 && menuChoiceList[3] <= sideItemList.size()){
                                System.out.println("Please choose your side item size: ");
                                printChoiceMenu(sizeList);
                                menuChoiceList[4] = Integer.parseInt(scanner.nextLine());
                               if(menuChoiceList[4] > 0 && menuChoiceList[4] <= sizeList.size()){
                                   OrderItem orderItem = null;
                                   if(menuChoiceList[0] == 2){
                                       orderItem = new OrderItem(drinkList.get(menuChoiceList[1]).getName(),
                                               sizeList.get(menuChoiceList[2]),
                                               drinkList.get(menuChoiceList[1]).getPrice(),
                                               sideItemList.get(menuChoiceList[3]).getName(),
                                               sizeList.get(menuChoiceList[4]),
                                               sideItemList.get(menuChoiceList[3]).getPrice()
                                       );
                                   }
                                   if(menuChoiceList[0] == 3){
                                       System.out.println("Enter name of your burger: ");
                                       String burgerName = scanner.nextLine();
                                       if(burgerName.isEmpty()){
                                           burgerName = "Custom burger";
                                       }
                                       orderItem = new OrderItem(burgerName.trim(),drinkList.get(menuChoiceList[1]).getName(),
                                               sizeList.get(menuChoiceList[2]),
                                               drinkList.get(menuChoiceList[1]).getPrice(),
                                               sideItemList.get(menuChoiceList[3]).getName(),
                                               sizeList.get(menuChoiceList[4]),
                                               sideItemList.get(menuChoiceList[3]).getPrice()
                                       );
                                   }

                                   System.out.println("Please choose your toppings: ");
                                   printChoiceMenu(toppingList);
                                   orderItem.addToppingItem(toppingList,toppingsCount);
                                   orderItem.showOrder();
                                   System.out.println("\n".repeat(1));
                               }
                               else{
                                   System.out.println("Not in menu!");
                               }
                            }
                            else{
                                System.out.println("Not in menu!");
                            }
                        }
                        else{
                            System.out.println("Not in the menu!");
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

    private static HashMap<Integer,String> loadSizeList(){
        HashMap<Integer,String> tmpList = new HashMap<>();
        tmpList.put(1,"Small");
        tmpList.put(2,"Medium");
        tmpList.put(3,"Large");
        return tmpList;
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
        tmpList.put(1, new Drink("Coca-Cola", 1.00));
        tmpList.put(2, new Drink("Fanta", 1.10));
        tmpList.put(3, new Drink("Sprite", 1.05));
        return tmpList;
    }
}
