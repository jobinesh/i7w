package com.jobinesh.i7w.dailycoding;

/**
 * Implement a stack that has the following methods:
 *
 * push(val), which pushes an element onto the stack
 * pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
 * max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
 * Each method should run in constant time.
 */
public class MinStack {
    int size=0;
    Node rearNode;
    class Node {
        Node next;
        Node prev;
        int value;
        int min=-1;
        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
    public void push(int value){


        if(rearNode ==null){
            Node newNode = new Node(value, value);
            rearNode =newNode;
        }else{
            Node newNode = new Node(value, Math.min(this.getMin(), value));
            newNode.setPrev(rearNode);
            rearNode.setNext(newNode);
            rearNode = newNode;
        }
        size++;
    }

    public int pop(){
        int value=-1;
        if(rearNode !=null){
            value =  rearNode.getValue();
            rearNode = rearNode.getPrev();
            if(rearNode != null) {
                rearNode.setNext(null);
            }else{
                rearNode = null;
            }
            size--;
        }
        return value;
    }
    public int getMin(){
        int value=-1;
        if(rearNode !=null){
            value =  rearNode.min;
        }
        return value;
    }
    public int top(){
        int value= -1;
        if(rearNode !=null){
            value =  rearNode.value;
        }
        return value;
    }
    public int getSize(){
        return size;
    }
    public static void main(String[] args){
        MinStack stack= new MinStack();
        stack.push(1);
        stack.push(5);
        stack.push(6);

        System.out.println( "Pop "+ stack.pop());
        System.out.println( "Min "+ stack.getMin());
    }
}
