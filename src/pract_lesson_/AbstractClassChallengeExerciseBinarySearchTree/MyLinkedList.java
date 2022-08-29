package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            //list is empty, so head sets to newItem
            this.root = newItem;
            return true;
        }

        ListItem currentItem = root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if(comparison < 0){
                //newItem is greater, move to right
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }
                else{
                    //there's no next, insert newItem at the end
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }
            else if(comparison > 0){
                //if newItem is less, insert before/to the left
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                }
                else{
                    //node with previous is the root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }

                return true;
            }
            else{
                //equal
                System.out.println(newItem.getValue() + "is already in the list");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item" + item.getValue());
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                //found record
                if(currentItem == this.root){
                    //current item is the head/root
                    this.root = currentItem.next();
                }
                else{
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }

                return true;
            }
            else if(comparison < 0){
                currentItem = currentItem.next();
            }
            else{
                //comparison > 0
                //currentItem greater than the one to be deleted, so item no in the list
                return false;
            }
        }

        //we have reached the end of the list, nothing to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("List is empty");
        }
        else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

//        //recursive method approach; call to a method itself
          //not a good approach with linkedlist, as depth is too large, too many records, as going through all nodes
//        if(this.root != null){
//            System.out.println(this.root.getValue());
//            traverse(this.root.next());
//        }

    }
}
