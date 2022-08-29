package pract_lesson_;

public class MinutesToYearsDaysCalculatorExercise {
    public static final String INV_VAL_MSG = "Invalid Value";
    public static void printYearsAndDays(long minutes){
        if(minutes < 0){
            System.out.println(INV_VAL_MSG);
            return;
        }

        long days = minutes / (24*60);
        long years = days / 365;
        long remainingDays = days % 365;
        System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
    }
}
