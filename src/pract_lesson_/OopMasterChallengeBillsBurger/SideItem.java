package pract_lesson_.OopMasterChallengeBillsBurger;

record SideItem (String name, double price){
    @Override
    public String toString() {
        return String.format("%s for the price of %.2f",this.name, this.price);
    }
}
