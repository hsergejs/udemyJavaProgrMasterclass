package pract_lesson_;

import java.util.Arrays;

public class ReverseArrayChallengeExercise {
    public static void reverse(int[] array){
        System.out.println(Arrays.toString(array));
        int maxIndex = array.length-1;
        //as one side of array already will be swapped with another half, no reason to continue
        int halfLength = array.length / 2;
        int tmp = array[0];
        for(int i=0;i<halfLength;i++){
            tmp = array[i]; //save element at first index
            array[i] = array[maxIndex-i]; //swap element at last index with first
            array[maxIndex-i] = tmp; //save element from fist index to the last
        }
        System.out.println(array.toString());
    }

    public void reverse1(int[] array){
        System.out.println("Array = " + Arrays.toString(array));
        int length = array.length-1;
        int halfLength = array.length / 2;
        int tmp;
        for(int i=0; i<halfLength;i++){
            tmp = array[i];
            array[i] = array[length-i];
            array[length-i] = tmp;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}
