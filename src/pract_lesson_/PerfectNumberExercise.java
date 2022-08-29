package pract_lesson_;

public class PerfectNumberExercise {
    public static boolean isPerfectNumber(int number){
        int sum = 0;
        int initNumber = number;
        if(number > 0){
            for(int i = 1; i < number; i++){
                if(number % i == 0){
                    System.out.println("Divisor: " + i);
                    sum += i;
                    System.out.println("Sum: " + sum);
                }
            }
            if(sum == initNumber){
                return true;
            }
        }

        return false;
    }
}
