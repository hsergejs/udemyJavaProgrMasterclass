package pract_lesson_;

public class NumberToWordsExercise {
    public static void numberToWords(int number) {
        if (number >= 0) {
            int lastDigit = 0;
            int digitsInitReversedNumber = getDigitCount(reverse(number));
            int digitsInitNumber = getDigitCount(number);
            int digitDifference = 0;

            number = reverse(number);

            do {
                lastDigit = number % 10;
                switch (lastDigit) {
                    case 0:
                        System.out.println("Zero");
                        break;
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                    default:
                        break;
                }
                number = number / 10;
            }
            while (number > 0);

            if(digitsInitNumber != digitsInitReversedNumber){
                digitDifference = digitsInitNumber-digitsInitReversedNumber;
                for(int i=0; i<digitDifference;i++){
                    System.out.println("Zero");
                }
            }

        } else {
            System.out.println("Invalid Value");
        }
    }

    public static int reverse(int number) {
        int initNumber = number;
        int reversedNumber = 0;
        int lastDigit = 0;
        while (number != 0) {
            lastDigit = number % 10;
            reversedNumber *= 10;
            reversedNumber += lastDigit;
            number = number / 10;
        }

        return reversedNumber;
    }

    public static int getDigitCount(int number) {
        int digits = 0;
        if (number >= 0) {
            do {
                digits++;
                number /= 10;
            }
            while (number > 0);

            return digits;
        }

        return -1;
    }
}
