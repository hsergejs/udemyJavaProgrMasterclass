package pract_lesson_;

public class DecimalComparatorExercise {
    boolean areEqualByThreeDecimalPlaces(double num, double num1){
        double numA = num*1000;
        double numB = num1*1000;
        if((int)numA == (int)numB){
            System.out.println("Num 1: " + numA);
            System.out.println("Num 2: " + numB);
            System.out.println("Are equal");
            return true;
        }
        System.out.println("Num 1: " + numA);
        System.out.println("Num 2: " + numB);
        System.out.println("not equal");
        return false;
    }
}
