package pract_lesson_.AddBasketLectureChallenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        //this.list = new HashMap<>();
        //TreeMap use comparaTo() and sort in alphabetical order Basket contents
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if(item != null && quantity > 0){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }

        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if(item != null && quantity > 0){
            //check contents
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;
            if(newQuantity > 0){
                list.put(item, newQuantity);
                return quantity;
            }
            else if(newQuantity == 0){
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket() {
        this.list.clear();
    }

    public Map<StockItem, Integer> Items (){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains " + list.size() + " items\n";
        double total = 0.0;
        for(Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            total += item.getKey().getPrice() * item.getValue();
        }

        return s + " Total cost " + total;
    }

    public int sellItem(StockList stockList, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(stockList.reserveStock(item,quantity) != 0){
            return addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public int removeItem(StockList stockList, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(removeFromBasket(stockItem,quantity) == quantity){
            return stockList.unreserveStock(item,quantity);
        }
        return 0;
    }

    public void checkOut(StockList stockList){
        for(Map.Entry<StockItem,Integer> item : Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        clearBasket();
    }
}
