package pract_lesson_;

public class EvenDigitSumExercise {
    public static int getEvenDigitSum(int number){
        if(number >= 0){
            int sum = 0;
            int lastDigit = 0;
            while(number > 0){
                lastDigit = number%10;
                if(lastDigit % 2 == 0){
                    sum += lastDigit;
                }
                number /= 10;
            }

            return sum;
        }

        return -1;
    }
}
