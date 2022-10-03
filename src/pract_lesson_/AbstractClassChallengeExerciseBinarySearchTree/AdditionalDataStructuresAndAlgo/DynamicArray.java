package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.AdditionalDataStructuresAndAlgo;

public class DynamicArray {
    private int[] data;
    private int internalIndex;

    public DynamicArray(int size){
        data = new int[size];
        internalIndex = 0;
    }
    public void insert(int item){
        if(internalIndex == data.length){
            int[] tmp = new int[data.length*2];
            for(int i=0; i<data.length; i++){
                tmp[i] = data[i];
            }
            data = tmp;
        }
        data[internalIndex++] = item;
    }
    public void removeAt(int index){
        if(index < 0 || index >= internalIndex){
            throw new IllegalArgumentException();
        }
        //[10,20,30,40]
        for(int i=index; i<internalIndex; i++){
            data[i] = data[i+1];
        }
        internalIndex--;
    }

    public int indexOf(int item){
        for(int i=0; i<internalIndex; i++){
            if(item == data[i]){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for(int i=0; i<internalIndex; i++){
            System.out.println(data[i]);
        }
    }
}
