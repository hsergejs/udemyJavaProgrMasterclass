package pract_lesson_;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortedArrayChallengeExercise {
    private static Scanner scanner;
    public static int[] getIntegers(int length){
        int[] array = new int[length];
        scanner = new Scanner(System.in);
        for(int i=0;i<length;i++){
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return array;
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        //sortedArray = Arrays.copyOf(array,array.length);
        for(int i=0;i<array.length;i++){
            sortedArray[i] = array[i];
        }

        int tmp; //per requirement in descending order, if ascending order then sortedArray[i] > sortedArray[j]
        for(int i=0;i<sortedArray.length;i++){
            for(int j=i+1;j<sortedArray.length;j++){
                if(sortedArray[i] < sortedArray[j]){
                    tmp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = tmp;
                }
            }

        }

        return sortedArray;
    }


    //bubble sort for lists
    public static void sortList(List<String> list){
        for(int i=0; i<list.size() - 1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
