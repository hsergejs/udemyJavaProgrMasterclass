package pract_lesson_.OopMasterChallengeBillsBurger;

record Drink(String size, double price) {
    @Override
    public String toString() {
        return String.format("%s drink for the price of %.2f",this.size,this.price);
    }
}
