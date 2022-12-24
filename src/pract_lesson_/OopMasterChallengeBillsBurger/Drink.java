package pract_lesson_.OopMasterChallengeBillsBurger;

class Drink {
    private String name,size;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public double getAdjustedPrice(String size){
        if(size.equalsIgnoreCase("small")){
            return price + 0.25;
        }
        else if(size.equalsIgnoreCase("medium")){
            return price + 0.5;
        }
        else if(size.equalsIgnoreCase("large")){
            return price + 0.75;
        }
        else{
            return price;
        }
    }

    @Override
    public String toString() {
        return String.format("%s for the price of %.2f",this.name, this.price);
    }
}
