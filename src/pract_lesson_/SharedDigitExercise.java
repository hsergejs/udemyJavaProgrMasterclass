package pract_lesson_;

public class SharedDigitExercise {
    public static boolean hasSharedDigit(int digitA, int digitB){
        int lastDigitA = 0;
        int lastDigitB = 0;
        boolean hasCommonDigit = false;
        int startValueDigitB = digitB;
        if((digitA >= 10 && digitA <= 99) && (digitB >= 10 && digitB <= 99)){
            while(digitA > 0){
                lastDigitA = digitA%10;
                System.out.println("Last digit A: " + lastDigitA);
                while(digitB > 0){
                    lastDigitB = digitB%10;
                    System.out.println("Last digit B: " + lastDigitB);
                    if(lastDigitA == lastDigitB){
                        hasCommonDigit = true;
                    }
                    digitB /= 10;
                }
                digitA /= 10;
                digitB = startValueDigitB; //reset value to restart the loop;
            }
            return hasCommonDigit;
        }

        return false;
    }
}
