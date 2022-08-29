package pract_lesson_;

import java.util.Scanner;

public class InputCalculatorExercise {
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        double avg = 0.0;
        int counter = 0;

        while(true){
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                sum += input;
                counter++;
            }
            else{
                break;
            }

            scanner.nextLine(); //set next line, as nextInt() breaks input loop
        }

        avg = (double)sum / (double)counter;
        long rounded = Math.round(avg);
        System.out.println("SUM = " + sum + " AVG = " + rounded);
        scanner.close();
    }
}
