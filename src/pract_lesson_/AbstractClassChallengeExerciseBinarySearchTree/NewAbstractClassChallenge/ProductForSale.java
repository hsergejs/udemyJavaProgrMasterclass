package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.NewAbstractClassChallenge;

public abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getTotalSalePrice(int quantity){
        return quantity*price;
    }

    public void printPricedLineItem(int quantity){
        System.out.printf("%2d quantity at $%8.2f each, %-15s, %-35s %n", quantity,price,type,description);
        //%-15s string with justifying 15 empty spaces from the left
        //%2d allow spacing for int
        //$%8.2f spacing for $0.00 double price
    }

    public abstract void showDetails();
}
