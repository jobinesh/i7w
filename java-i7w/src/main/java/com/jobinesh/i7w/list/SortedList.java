package com.jobinesh.i7w.list;

public class SortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null ){
            return null;
        }
        ListNode currentNod = head.next;
        ListNode prevNode = head;
        while (currentNod != null) {
            if (prevNode.val != currentNod.val) {
                prevNode.next = currentNod;
                prevNode = currentNod;
            }
            currentNod = currentNod.next;
            prevNode.next = null;
        }
        return head;
    }

    public static void main(String[] arg) {
        ListNode node1 = new ListNode();
        node1.val=1;
         ListNode node2 = new ListNode();
        node2.val =2;
        node1.next=node2;
/*
        ListNode node3 = new ListNode();
        node3.val =2;
        node2.next=node3;
        ListNode node4 = new ListNode();
        node4.val =3;
        node3.next=node4;
        ListNode node5 = new ListNode();
        node5.val =3;
        node4.next=node5;*/
        ListNode nonDuplicated = new SortedList().deleteDuplicates(node1);
        while(nonDuplicated != null){
            System.out.println("Node[val]: "+ nonDuplicated.val);
            nonDuplicated= nonDuplicated.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
