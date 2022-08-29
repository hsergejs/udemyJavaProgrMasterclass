package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem room);
}
