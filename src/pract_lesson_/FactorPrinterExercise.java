package pract_lesson_;

public class FactorPrinterExercise {
    static final String INV_VAL_MSG = "Invalid Value";
    public static void printFactors(int number){
        if(number > 0){
            for(int i=1; i<=number; i++){
                if(number%i == 0){
                    System.out.println(i);
                }
            }
        }
        else{
            System.out.println(INV_VAL_MSG);
        }
    }
}
