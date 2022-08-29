package pract_lesson_;

import java.util.Scanner;

public class MinimumElementExercise {
    private static Scanner scanner;
    public int readInteger(){
        scanner = new Scanner(System.in);
        System.out.println("Enter count: ");
        int arrayLength = scanner.nextInt();
        scanner.close();
        return arrayLength;
    }

    public int[] readElements(int arrayLength){
        scanner = new Scanner(System.in);
        int[] array = new int[arrayLength];
        for(int i=0; i<arrayLength; i++){
            System.out.println("Enter number: ");
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    public int findMin(int[] array){
        int minValue = array[0];
        for(int i=1; i<array.length;i++){
            if(minValue > array[i]){
                minValue = array[i];
            }
        }
        return minValue;
    }
}
