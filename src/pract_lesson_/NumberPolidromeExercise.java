package pract_lesson_;

public class NumberPolidromeExercise {
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int lastDigit = 0;
        int initNumber = number;
        //121
        while(number != 0){
            System.out.println("Initial number: " + number);

            lastDigit = number%10;
            System.out.println("LastDigit: " + lastDigit);

            reverse = reverse * 10;
            System.out.println("Reverse: " + reverse);

            reverse += lastDigit;
            System.out.println("Reverse added up last digit: " + reverse);

            number = number/10;
            System.out.println("Number shifted: " + number);
        }


        System.out.println("Initial number: " + initNumber);
        System.out.println("Final re-reversed number: " + reverse);

        if(initNumber == reverse){
            return true;
        }

        return false;
    }
}
