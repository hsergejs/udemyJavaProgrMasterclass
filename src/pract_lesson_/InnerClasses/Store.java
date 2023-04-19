package pract_lesson_.InnerClasses;

public class Store {
    public static void main(String[] args) {
        Meal meal = new Meal();
        meal.addToppings("pickles","onion","mayo");
        System.out.println(meal);

        Meal mealUSD = new Meal(0.68);
        System.out.println(mealUSD);
    }
}
