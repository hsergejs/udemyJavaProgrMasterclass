package pract_lesson_;

import java.util.Scanner;

public class UserInputChallenge {
    Scanner scanner = new Scanner(System.in);

    public double readUserInput(){
        boolean isFinished = false;
        int count = 1;
        double sum = 0.0d;
        do{
            System.out.println("Enter number: #" + count);
            try{
                sum += Double.parseDouble(scanner.nextLine());
                count++;
                if(count == 6){
                    isFinished = true;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Only numeric values are allowed. Please try again!");
            }
        }
        while(!isFinished);
        return sum;
    }


}
