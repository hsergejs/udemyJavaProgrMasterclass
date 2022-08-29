package pract_lesson_;

public class LargestPrimeExercise {
    public static int getLargestPrime(int number){
        int prime = -1;
        if(number > 1){
            for(int i=2; i<=number;i++){
                if(number % i == 0){
                    prime = i;
                    number = number/i;
                    i--;
                }
            }

            return prime;
        }
        return -1;
    }
}
