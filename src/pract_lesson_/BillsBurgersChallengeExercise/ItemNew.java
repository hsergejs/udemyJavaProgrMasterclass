package pract_lesson_.BillsBurgersChallengeExercise;

public class ItemNew {
    private String type; //burger, drink, topping etc
    private String name;
    private double price;
    private String size = "MEDIUM";

    public ItemNew(String type, String name, double price) {
        //can be added validation of type, if type is a valid type
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    public String getName() {
        if(type.equals("SIDE") || type.equals("DRINK")){
            return size + " " + name;
        }

        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice(){
        return switch(size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static void printItem(String name, double price){ //static to give all access
        System.out.printf("%20s:%6.2f%n", name, price); //%20s length of string, provide padding from left
        // and %6.2f length of double, provide padding from left
    }

    public void printItem(){
        printItem(getName(),getAdjustedPrice()); //will be overriden
    }
}
