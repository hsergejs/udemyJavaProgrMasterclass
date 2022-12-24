package pract_lesson_.OopMasterChallengeBillsBurger;

class SideItem{
    private String name,size;
    private double price;

    public SideItem(String name, double price) {
        this.name = name;
        this.price = price;
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

    public void setSize(String size) {
        this.size = size;
    }

    public double getAdjustedPrice(String size){
        if(size.equalsIgnoreCase("small")){
            return price + 0.5;
        }
        else if(size.equalsIgnoreCase("medium")){
            return price + 0.75;
        }
        else if(size.equalsIgnoreCase("large")){
            return price + 1.0;
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
