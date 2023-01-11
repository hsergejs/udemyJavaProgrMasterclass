package pract_lesson_;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {

    private int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        while(true){
            try{
                return scanner.nextInt();
            }
            catch(InputMismatchException e){
                //to clear new line bug in scanner
                scanner.nextLine();
                System.out.println("Only numbers are allowed");
            }
        }
    }

    public int divide(){
        int x;
        int y;
//        try{
            x = getInt();
            y = getInt();
            return x/y;
//        }
//        catch(NoSuchElementException e){
//            throw new NoSuchElementException("incorrect input"); //raised if entered ^D (cntr d)
//        }
//        catch (ArithmeticException e){
//            throw new ArithmeticException("no division by 0 allowed");
//        }
    }
}
