package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.NewAbstractClassChallenge;

public class MonitorProductObject extends ProductForSale{
    public MonitorProductObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("Item: %s, price: %6.2f,%ndescription for monitor item: %s%n",type,price,description);
    }
}
