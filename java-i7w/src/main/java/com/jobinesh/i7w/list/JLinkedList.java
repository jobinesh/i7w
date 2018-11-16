/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.list;

/**
 *
 * @author Jobinesh
 */
public class JLinkedList {

    private Node node = null;
    private Node head = null;

    public void add(JLinkedList.Node node) {

        if (this.node != null) {
            this.node.next = node;
        }
        if (this.head == null) {
            this.head = node;
        }
        this.node = node;

    }

    @Override
    public String toString() {
        return "JLinkedList{" + "head=" + head + '}';
    }

    public static class Node implements Cloneable {

        String data;
        Node next;

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", next=" + next + '}';
        }

    }

    public static JLinkedList reverse(JLinkedList list) {
        JLinkedList reversedList = new JLinkedList();
        Node currentNode = list.head;
        Node prevNode = null;
        while (currentNode != null) {

            Node reversedNode = new Node();
            reversedNode.data = currentNode.data;
            reversedNode.next = prevNode;
            prevNode = reversedNode;
            System.out.println("prevNode: " + prevNode);
            currentNode = currentNode.next;

        }
        reversedList.head = prevNode;
        return reversedList;
    }

    public void reverseOrder() throws Exception {
        Node currentNode = this.head;
        Node prevNode = null;
        while (currentNode != null) {

            Node reversedNode = (Node) currentNode.clone(); //new Node();
            reversedNode.next = prevNode;
            prevNode = reversedNode;
            currentNode = currentNode.next;

        }
        this.head = prevNode;
        //return reversedList;
    }

    public Node getMiddleElement() {
        Node middleNode = head;
        Node currentNode = head;
        int totalcount = 1;
        while (currentNode != null) {
            if ((totalcount % 2 == 0)) {
                middleNode = middleNode.next;
            }
            totalcount++;
            currentNode = currentNode.next;
        }
        return middleNode;
    }

    private static JLinkedList constructList(int size) {
        JLinkedList list = new JLinkedList();
        Node prev = null;
        for (int i = 0; i < size; i++) {
            JLinkedList.Node node = new JLinkedList.Node();
            node.data = "Data" + i;
            list.add(node);
        }
        return list;
    }

    public static int count(JLinkedList list) {
        Node node = list.node;
        int cnt = count(node, 0);
        return cnt;
    }

    private static int count(Node node, Integer cnt) {
        System.out.println(cnt);
        cnt = cnt + 1;
        if (node.next != null) {
            return count(node.next, cnt);
        }

        return cnt;
    }

    public static Node falutyNode(JLinkedList list) {
        Node fast = list.head;
        Node slow = list.head;
        Node faulty = null;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                faulty = fast;
                break;
            }
        }
        return faulty;
    }

    public static Node getElementFromEndAt(JLinkedList list, int cnt) {
        Node node = list.head;
        Node nodeNth = list.head;

        int index = 0;
        while (node != null) {
            index++;
            node = node.next;
            if (index > cnt) {
                nodeNth = nodeNth.next;
            }

        }
        return nodeNth;
    }

    public static void main(String[] arg) throws Exception {
        JLinkedList list = constructList(15);

        System.out.println("starting :");
        System.out.println("Node :" + falutyNode(list));

        String s3 = "JournalDev";
        int start = 1;
        char end = 5;
        System.out.println(start + end);
        System.out.println(s3.substring(start, end));

    }

}
