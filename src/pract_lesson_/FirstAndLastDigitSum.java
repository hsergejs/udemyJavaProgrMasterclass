package pract_lesson_;

public class FirstAndLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        if(number >= 0){
            int sum = 0;
            int lastDigit = 0;
            int initNumber = number;

            System.out.println("Init number: " + initNumber);
            while(number > 0){
                lastDigit = number%10;
                System.out.println("Last digit: " + lastDigit);
                if(number == initNumber){
                    sum += lastDigit;
                    System.out.println("Sum with first digit: " + sum);
                }
                number = number/10;
                System.out.println("Current number: " + number);
                if(number == 0){
                    sum += lastDigit;
                    System.out.println("Sum with last digit: " + sum);
                }
            }
            return sum;
        }

        return -1;
    }
}
