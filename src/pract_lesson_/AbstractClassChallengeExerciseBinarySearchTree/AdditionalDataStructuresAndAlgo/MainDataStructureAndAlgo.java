package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.AdditionalDataStructuresAndAlgo;

public class MainDataStructureAndAlgo {
    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(3);
        numbers.print();
        System.out.println("Index of number in array: " + numbers.indexOf(30));

    }
}