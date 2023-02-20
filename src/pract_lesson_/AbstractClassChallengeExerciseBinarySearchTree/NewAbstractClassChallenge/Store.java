package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.NewAbstractClassChallenge;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductForSale> productList = new ArrayList<>();
    public static void main(String[] args) {
        productList.add(new LaptopProductObject("Lenovo laptop",899.99,"Fine laptop with aluminium cover"));
        productList.add(new MonitorProductObject("Samsung monitor",300.00,"Edged monitor for your station"));
        productList.add(new KeyboardProductObject("Logitec keyboard",65.39,"Perfect keyboard for typing"));

        printProductList();

        System.out.println("*".repeat(30));
        System.out.println("Order 1: ");
        var orderList1 = new ArrayList<OrderItem>();
        addItemToOrder(orderList1,0,1);
        addItemToOrder(orderList1,2,2);
        printOrderList(orderList1);
    }

    private static void addItemToOrder(ArrayList<OrderItem> orderList, int indexInProductList, int quantity){
        orderList.add(new OrderItem(quantity, productList.get(indexInProductList)));
    }

    private static void printOrderList(ArrayList<OrderItem> itemsInOrder){
        double totalPrice = 0.0;
        for(var item : itemsInOrder){
            item.product().printPricedLineItem(item.quantity());
            totalPrice += item.product().getTotalSalePrice(item.quantity());
        }
        System.out.printf("Total order price: $%6.2f", totalPrice);
    }

    private static void printProductList(){
        System.out.println("Items in the product list: ");
        for(var product : productList){
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }
}
