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

    private Node head = null;
    private Node currentNode = null;

    public void add(JLinkedList.Node node) {
        if (head == null) {
            head = node;
        }
        if (currentNode != null) {
            currentNode.next = node;
        }
        currentNode = node;

    }

    public static class Node {

        String data;
        Node next;
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
        Node node = list.head;
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

    public static void main(String[] arg) {
        JLinkedList list = constructList(11);
        System.out.println("count:" + count(list));
    }

}
