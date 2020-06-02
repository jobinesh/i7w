package com.jobinesh.i7w.array;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    HashMap<Integer,Integer> cache = new HashMap();
    LinkedList<Integer> cacheHitList = new LinkedList<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value= cache.get(key);
        if(value != null ) {
            int index = cacheHitList.indexOf(key);
            if(index != -1){
                cacheHitList.remove(index);
            }
            cacheHitList.addFirst(key);
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(cache.containsKey(key)) {
            cacheHitList.remove( Integer.valueOf(key));
        }else if(cache.size()==capacity){
           Integer cacheKey= cacheHitList.removeLast();
           cache.remove(cacheKey);
        }
        cache.put(key, value);
        cacheHitList.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);

        print(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        print(cache.get(2));
    }
    public static void print(Integer obj){
        System.out.println( "Value: "+obj);
    }
    /*
    ["LRUCache","put","put","get","put","put","get"]
[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

    ["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

 print(cache.get(2));
        cache.put(2, 6);
        print(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        print(cache.get(1));
        print(cache.get(2));


 cache.put(1, 1);
        cache.put(2, 2);
        print(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        print(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        print(cache.get(1));       // returns -1 (not found)
        print(cache.get(3));       // returns 3
        print(cache.get(4));       // returns 4
     */
    /*
    static class DoubleLinkedList{
        Node head;
        Node tail;
        Node current;
        void add(Node node){
            if(head==null){
                head=node;
            }else{
                current.next=node;
                node.prev=current;
            }
            current=node;
            current.next=null;
            tail = current;
        }
        void addAtHead(Node node){
            if(head==null){
                head=node;
                tail=head;
            }else{
                node.next = head;
                head.prev=node;
                head=node;
            }
        }
        void addAtTail(Node node){
            if(tail==null){
                tail=node;
                head=node;
            }else{
                node.prev = tail;
                tail.next=node;
                tail=node;
            }
        }
    }
    static class Node{
        Node prev;
        Node next ;
    }*/
}