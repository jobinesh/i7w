package com.jobinesh.i7w.dailycoding;

/**
 * Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
 * <p>
 * The list is very long, so making more than one pass is prohibitively expensive.
 * <p>
 * Do this in constant space and in one pass.
 */
public class LLSolution {
    static class ListNode {
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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + val +
                    ", next='" + next + '\'' +
                    '}';
        }
    }

    static class JLinkedList {
        private ListNode start;

        public void addNode(ListNode node) {
            if (start == null) {
                start = node;
                return;
            }
            ListNode nextNode = start;
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = node;
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null){
                return null;
            }
            ListNode nextNode = head;
            int count = 0;
            ListNode prevNodetoN = null;

            while (nextNode.next != null) {
                if (count >= n) {
                    prevNodetoN = prevNodetoN.next;
                } else {
                    if (prevNodetoN == null) {
                        prevNodetoN = nextNode;
                    }
                }
                nextNode = nextNode.next;
                count = count + 1;
            }
            if( count+1 == n){
                ListNode removedNode = head;
                head = head.next;
            }
            if (count >= n) {
                ListNode removedNode = prevNodetoN.next;
                prevNodetoN.next = removedNode.next;
                removedNode.next = null;
            }
            return head;

        }


        public void print() {
            System.out.println(start);
        }
    }


    public static void main(String[] args) {
        LLSolution.JLinkedList list = new LLSolution.JLinkedList();
        addNodes(list, 1);
        list.print();
        System.out.println(list.removeNthFromEnd(list.start, 1));
        list.print();
    }

    public static void addNodes(LLSolution.JLinkedList list, int count) {
        for (int i = 1; i <= count; i++) {
            ListNode node1 = new ListNode();
            node1.val = i;
            list.addNode(node1);
        }
    }
}
