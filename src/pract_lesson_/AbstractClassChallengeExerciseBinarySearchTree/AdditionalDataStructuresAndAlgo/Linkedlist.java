package pract_lesson_.AbstractClassChallengeExerciseBinarySearchTree.AdditionalDataStructuresAndAlgo;

import java.util.NoSuchElementException;

public class Linkedlist {
    private NodeLinkedlist firstNode; //head
    private NodeLinkedlist lastNode; //tail

    private class NodeLinkedlist {
        private int nodeValue; //node value
        private NodeLinkedlist nextNode; //next node location in memory

        public NodeLinkedlist(int item){
            this.nodeValue = item;
        }
    }

    public void addLast(int item){
        var node = new NodeLinkedlist(item); //node must always contain a value
        if(isEmpty()){ //no values in the list, as head must be init
            firstNode = lastNode = node; // same as firstNode = node; lastNode = node;
        }

        lastNode.nextNode = node; //link to the next node !!! and only then set node
        lastNode = node; //setting last node
    }

    public void addFirst(int item){
        var node = new NodeLinkedlist(item); //wrap passed value with node
        if(isEmpty()){ //no items in the list
            firstNode = lastNode = node; //set head and tail
        }

        firstNode.nextNode = firstNode; //link current head node to next node !!! and only then set node
        firstNode = node; //and set head to passed node
    }

    public int indexOf(int item){
        int curIndex = 0; //set index value
        var curNode = firstNode; //start from head
        while(curNode != null){ //test current node, not next node !!!
            if(curNode.nodeValue == item){
                return curIndex;
            }
            curNode = curNode.nextNode;
            curIndex++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException(); //as per built in LinkedList
        }

        //if there's only one element
        if(firstNode == lastNode){
            firstNode = lastNode = null;
            return;
        }

        //[10 -> 20 -> 30] initial
        //[10 -> (20) -> 30] first track second node, as we remove link it will be lost
        var secondNode = firstNode.nextNode;
        //[10 20 -> 30] remove link, so garbage collector can collect it
        firstNode.nextNode = null;
        //set second node as a head
        firstNode = secondNode;
    }

    public void removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if(firstNode == lastNode){
            firstNode = lastNode = null;
            return;
        }

        //[10 -> 20 -> 30] initial state
        //getting before last node
        var previousNode = getPreviousNode(lastNode);
        //setting last node
        lastNode = previousNode;
        //so that garbage collector can wipe out -> 30 remove link
        lastNode.nextNode = null;
    }

    private NodeLinkedlist getPreviousNode(NodeLinkedlist node){
        var curNode = firstNode;
        while(curNode != null){ //we need to find node before the last node
            if(curNode.nextNode == node){ //if we have reached node before the last node, e.g. link is pointing to the last node
                return curNode; //last node is found, return it
            }
            //otherwise move forward
            curNode = curNode.nextNode;
        }
        return null; //no last node were found
    }
    private boolean isEmpty(){
        return firstNode == null;
    }
}
