package pract_lesson_;

public class DigitSumChallenge {
    //n%10 - extract the least-significant digit
    // (example 125/10 => 12 -> 12*10 => 120 -> 125-120 => 5)
    //n = n/10 - drop the least least-significant digit

    public static int sumDigit(int number) {
        int sum = 0;
        if(number >= 10){
            while(number > 0){
                System.out.println("Passed number is: " + number);
                //extract the least-significant digit
                int lastDigit = number%10;
                System.out.println("Last digit value: " + lastDigit);
                sum += lastDigit;
                System.out.println("Sum of digits: " + sum);
                //drop the least least-significant digit
                number = number/10;
                System.out.println("After drop digit passed number is: " + number);
            }

            System.out.println("Total sum of digits: " + sum);
            return sum;
        }
        System.out.println(-1);
        return -1;
    }
}
