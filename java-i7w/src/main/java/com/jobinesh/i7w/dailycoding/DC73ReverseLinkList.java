package com.jobinesh.i7w.dailycoding;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Google.
 *
 * Given the head of a singly linked list, reverse it in-place.
 */
public class DC73ReverseLinkList {

    public ListNode reverseList(ListNode startNode){
        if(startNode==null ){
            return null;
        }
        ListNode prevNode= startNode;
        ListNode currentNode= startNode.next;
        prevNode.next=null;
        while(currentNode !=null){
            ListNode nextCurrentNode = currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode = nextCurrentNode;
        }
        return prevNode;
    }
    public static void print(ListNode  startNode){
        ListNode tmp=startNode;
        while(tmp != null){
            System.out.println( "Node: "+ tmp.val);
            tmp = tmp.next;
        }
    }
    public static void main(String[] args){
        DC73ReverseLinkList list = new DC73ReverseLinkList();
        ListNode head  = new ListNode(1,new ListNode(2, new ListNode(3,  new ListNode(4))));
         list.print(head);
        ListNode reversed = list.reverseList(head);
        list.print(reversed);
        list.print(head);

    }
    static class ListNode {
        private ListNode next;
        private int val;

        public ListNode(int val, ListNode next) {
            this.next = next;
            this.val = val;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }


        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

    }

}
