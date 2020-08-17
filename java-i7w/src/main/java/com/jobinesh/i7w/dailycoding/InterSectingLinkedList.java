package com.jobinesh.i7w.dailycoding;
/*
Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class InterSectingLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if( headA == null || headB==null){
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB =  headB;
        ListNode interSection = null;
        boolean isLooped =  false;
        int lenA=0;
        int lenB=0;
        while(currentA != null){
            currentA = currentA.next;
            lenA++;
        }
        while(currentB != null){
            currentB = currentB.next;
            lenB++;
        }
        currentA=headA;
        currentB=headB;
        if(lenA>lenB){
            int dff= lenA-lenB;
            while(dff>0){
                currentA = currentA.next;
                dff--;
            }
        }else if(lenB>lenA){
            int dff= lenB-lenA;
            while(dff>0){
                currentB = currentB.next;
                dff--;
            }
        }
        while( currentA != null ){
            if(currentA == currentB){
                interSection= currentA;
                break;
            }
            currentA=currentA.next;
            currentB=currentB.next;
        }
        return interSection;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB==null){
            return null;
        }
        if(headA== headB){
            return headB;
        }
        ListNode currentA = headA;
        ListNode currentB =  headB;

        while(currentA != currentB ){
            currentA = currentA.next;
            currentB = currentB.next;
            if(currentA  == currentB){
                break;
            }
            if(currentA == null ){
                currentA = headB;

            }
            if(currentB == null ){
                currentB = headA;
            }

        }

        return currentA;
    }

    public static void main(String[] args){
        ListNode headA = new ListNode(3);
        /*
        ListNode nodeA1 = new ListNode(1);
        headA.next=nodeA1;
        ListNode nodeA2 = new ListNode(8);
        nodeA1.next=nodeA2;
        ListNode nodeA3 = new ListNode(4);
        nodeA2.next=nodeA3;
        ListNode nodeA4 = new ListNode(5);
        nodeA3.next=nodeA4;*/

        ListNode headB = new ListNode(1);
        ListNode nodeB1 = new ListNode(6);
        headB.next=headA;
        /*
        ListNode nodeB2 = new ListNode(1);
        nodeB1.next=nodeB2;
       // ListNode nodeB3 = new ListNode(8);
        nodeB2.next=nodeA2;
       // ListNode nodeB4 = new ListNode(4);
       // nodeB3.next=nodeB4;
       // ListNode nodeB5 = new ListNode(5);
       // nodeB4.next=nodeB5;*/
        System.out.println( headA );
        System.out.println( headB );
        ListNode intersect = new InterSectingLinkedList().getIntersectionNode(headB, headA);
        System.out.println("intersect"+intersect);
    }
}
