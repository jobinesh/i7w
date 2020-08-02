package com.jobinesh.i7w.leetcode.random;

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeSortedList {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode resultHead = null;
        ListNode result = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (result == null) {
                    result = l2;
                    resultHead = result;
                } else {
                    result.next = l2;
                }
                break;
            }
            if (l2 == null) {
                if (result == null) {
                    result = l1;
                    resultHead = result;
                } else {
                    result.next = l1;
                }
                break;
            }

            if (l1.val < l2.val) {
                if (result == null) {
                    result = l1;
                    resultHead = result;
                } else {
                    result.next = l1;
                    result=result.next;
                }
                l1 = l1.next;
            } else {
                if (result == null) {
                    result = l2;
                    resultHead = result;
                } else {
                    result.next = l2;
                    result=result.next;
                }
                l2 = l2.next;
            }
        }
        return resultHead;
    }

    public static class ListNode {
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
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args){
        ListNode l11 = new ListNode();
        l11.val=1;
        ListNode l12 = new ListNode();
        l12.val=2;
        l11.next=l12;
        ListNode l13 = new ListNode();
        l13.val=4;
        l12.next=l13;

        ListNode l21 = new ListNode();
        l21.val=1;
        ListNode l22 = new ListNode();
        l22.val=3;
        l21.next=l22;
        ListNode l23 = new ListNode();
        l23.val=4;
        l22.next=l23;
        ListNode result =new MergeSortedList().mergeTwoLists(l11,l21);
        while(result != null){
            System.out.println( result.val);
            result = result.next;
        }
    }
}