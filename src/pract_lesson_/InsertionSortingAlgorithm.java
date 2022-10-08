package pract_lesson_;

public class InsertionSortingAlgorithm {
    //worst time complexity O(n^2) and best O(n)
    public void sort(int[] array){
        //checking current item with next and if required shifting it to the right position (not swapping),
        //while traversing and reaching the end
        //first item is assumed in the correct position
        //check with next value, if required store next value and copy(shift) current value to next value place
        //and save stored next value to current value place
        //[8,2,4,1,3] - store 2, shift 8 to place of 2, place 2 to 8th place -> [2,8,4,1,3]
        //when getting to value 1, values 8,4,2 are shifted to the right and one inserted at first position
        //distinct from bubble sort - on each iteration 8 will shift to the end, till it reach final place,
        //as it's highest value

        //start from second index as we assume it's in correct position
        for(var i = 1; i < array.length; i++){
            var current = array[i];
            //we compare current and previous positions
            var j = i-1;
            //if previous item is bigger, than current
            while(j>=0 && array[j]>current){
                //we shift/insert it to the right
                array[j+1] = array[j];
                j--;
            }
            //if we reach end and all greater items are shifter to the right
            array[j+1] = current;
        }
    }

    //another example

}
