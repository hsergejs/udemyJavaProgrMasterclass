package pract_lesson_.AddBasketLectureChallenge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> list;

    public StockList() {
        //this.list = new HashMap<>();
        //this will sort list in alphabetical order, as adding items
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //adding item to the list, if item not in the list method will add it and return default value,
            // if it exists in the list, return existing item
            // e.g. list.getOrDefault("Java", "NotFound");
            //if "Java" is present it will return "Java", if not, return "NotFound"
            StockItem inStock = list.getOrDefault(item.getName(), item);
            System.out.println(inStock);
            //if there's stock, adjust it
            if(item != inStock){
                item.adjustStock(inStock.availableQuantity());
            }

//            //old way
//            StockItem inStock = list.get(item.getName());
//            if(inStock != null){
//                item.adjustStock(inStock.availableQuantity());
//            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }

        return 0;
    }

    public int sellStock(String item, int quantity){
//        StockItem inStock = list.getOrDefault(item, null);
//        if(inStock != null && inStock.availableQuantity() >= quantity && quantity > 0){
//            inStock.adjustStock(-quantity); //!!! "-"
//            return quantity;
//        }
//
//        return 0;

        StockItem inStock = list.get(item);
        if(inStock != null && quantity > 0){
            return inStock.finaliseStock(quantity);
        }

        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if(inStock != null && quantity > 0){
            return inStock.reserveStock(quantity);
        }

        return 0;
    }

    public int unreserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if(inStock != null && quantity > 0){
            return inStock.unreserveStock(quantity);
        }

        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String,StockItem> Items(){
        //returns Map that unmodifiable
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock list\n";
        double total = 0.0;

        for(Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            total += itemValue;
        }

        return s + "Total stock value " + String.format("%.2f",total);
    }
}
