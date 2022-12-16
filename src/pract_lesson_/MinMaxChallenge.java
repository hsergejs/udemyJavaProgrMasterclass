package pract_lesson_;

import java.util.Scanner;

public class MinMaxChallenge {
    Scanner scanner = new Scanner(System.in);

    public void minMaxNumber(){
        double min = 0;
        double max = 0;
        int loopCount = 0;
        do{
            System.out.println("Please choose action:");
            System.out.println("any character - quit");
            System.out.println("number - play min max");
            try{
                double input = Double.parseDouble(scanner.nextLine());
                if(input < min || loopCount == 0){
                    min = input;
                }

                if(input > max || loopCount == 0){
                    max = input;
                }

                System.out.println("Min value: " + min);
                System.out.println("Max value: " + max);

                loopCount++;
            }
            catch(NumberFormatException e){
                break;
            }
        }
        while(true);
    }
}
