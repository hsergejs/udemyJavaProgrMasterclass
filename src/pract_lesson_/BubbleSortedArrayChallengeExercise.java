package pract_lesson_;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BubbleSortedArrayChallengeExercise {
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

    public static int[] bubbleSortIntegers(int[] array) {
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
    public static void bubbleSortList(List<String> list){
        for(int i=0; i<list.size() - 1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    //other bubble sort (worst time complexity O(n^2) and best O(n))
    //bubble sort traverse in array, check each element with next and if required swap them
    public static void otherArrayBubbleSort(int[] array){
        //if array is already sorted then only one pass is required
        boolean isSorted;
        for(var i=0;i<array.length; i++){
            isSorted = true;
            //on first iteration it will go full circuit as i=0, on second and so on last item is already sorted, so excluded
            for(var j=1; j<array.length-i; j++){
                if(array[j]<array[j-1]){
                    //extracting allow better readability
                    swap(array, j, j-1);
                    isSorted = false;
                }
            }
            //array is sorted break out from loop
            if(isSorted){
                return;
            }
        }
    }
    //private additional method for this bubble sort
    private static void swap(int[] array, int indexCur, int indexPrev){
        var tmp = array[indexCur];
        array[indexCur] = array[indexPrev];
        array[indexPrev] = tmp;
    }
}
