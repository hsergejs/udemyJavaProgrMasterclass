package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.NewAbstractClassChallenge;

public class LaptopProductObject extends ProductForSale{

    public LaptopProductObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("Item: %s, price: %6.2f,%ndescription for laptop item: %s%n",type,price,description);
    }
}
