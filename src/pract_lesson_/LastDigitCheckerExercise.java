package pract_lesson_;

public class LastDigitCheckerExercise {
    public static boolean hasSameLastDigit(int digitA, int digitB, int digitC){
        if((digitA >= 10 && digitA <= 1000) && (digitB >= 10 && digitB <= 1000) && (digitC >=10 && digitC <= 1000)){
            if(digitA%10 == digitB%10 || digitA%10 == digitC%10 || digitB%10 == digitC%10){
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(int number){
        if(number >= 10 && number <= 1000){
            return true;
        }
        return false;
    }
}
