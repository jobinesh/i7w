package com.jobinesh.i7w.dailycoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement an LFU (Least Frequently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
 * <p>
 * set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least frequently used item. If there is a tie, then the least recently used key should be removed.
 * get(key): gets the value at key. If no such key exists, return null.
 */
public class DC67LFUCache {
    static class LFUCache {
        private int capacity;
        private Map<Integer, Node> cache = new HashMap();
        Node headNode = null;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {

            Node node = cache.get(key);
            if (node != null) {
                node = removeNode(node);
                node.setFrequency(node.getFrequency() + 1);
                this.addNode(node);
                cache.put(key, node);
                return node.getValue();
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            Node existingNode = cache.get(key);
            if (existingNode != null) {
                removeNode(existingNode);
                cache.remove(key);
            }
            if (cache.size() == capacity) {
                int keyToRemove = headNode.getKey();
                if (headNode.getNext() != null) {
                    headNode = headNode.getNext();
                    headNode.setPrev(null);
                } else {
                    headNode = null;
                }
                cache.remove(keyToRemove);
            }

            Node currentNode = new Node();
            currentNode.setFrequency(0);
            currentNode.setKey(key);
            currentNode.setValue(value);
            this.addNode(currentNode);
            cache.put(key, currentNode);
        }

        private void addNode(Node node) {
            if (headNode == null) {
                headNode = node;
            } else {
                Node tmp = headNode;
                while (tmp.getNext() != null) {
                    if (tmp.getFrequency() > node.getFrequency()) {
                        break;
                    }
                    tmp = tmp.getNext();
                }
                if (tmp.getNext() == null) {
                    if (tmp == headNode && tmp.getFrequency() > node.getFrequency()) {
                        node.setPrev(null);
                        node.setNext(tmp);
                        tmp.setPrev(node);
                        tmp.setNext(null);
                        headNode = node;
                    } else {
                        tmp.setNext(node);
                        node.setPrev(tmp);
                    }
                } else {
                    if (tmp.getPrev() != null) {
                        tmp.getPrev().setNext(node);
                        node.setPrev(tmp.getPrev());
                    } else {
                        headNode = node;
                    }
                    node.setNext(tmp);
                    tmp.setPrev(node);
                }
            }
        }

        private Node removeNode(Node node) {
            Node tmp = headNode;
            while (tmp != null) {
                if (tmp.getKey() == node.getKey()) {
                    break;
                }
                tmp = tmp.getNext();
            }
            if (tmp != null) {
                if (tmp.getPrev() != null) {
                    tmp.getPrev().setNext(tmp.getNext());
                }
                if (tmp.getNext() != null) {
                    tmp.getNext().setPrev(tmp.getPrev());
                }
                if (tmp.getPrev() == null) {
                    headNode = tmp.getNext();
                }
                tmp.setPrev(null);
                tmp.setNext(null);
            } else {
                headNode = null;
            }
            return tmp;
        }
    }


    static class Node {
        private Node next;
        private Node prev;
        private int value;
        private int key;
        private int frequency;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
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

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
        LFUCache cache2 = new LFUCache(2 /* capacity */);

        cache2.put(2, 1);
        cache2.put(2, 2);
        System.out.println(cache2.get(2));       // returns 1
        cache2.put(1, 1);    // evicts key 2
        cache2.put(4, 1);    // evicts key 1.
        System.out.println(cache2.get(2));       //
    }

    /**
     * ["LFUCache","put","put","get","put","put","get"]
     * [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
     * [null,null,null,2,null,null,-1]
     * Expected
     * [null,null,null,2,null,null,2]
     *
     * @param args
     */
    public static void main2(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);    // evicts key 1.
        System.out.println(cache.get(2));       // returns -1 (not found)

    }
    /**
     * ["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
     * [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
     * Output
     * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,24,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,24,null,null,null,-1,null,null,null,-1,18,18,null,null,null,null,-1,null,null,null,null,null,null,null]
     * Expected
     * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,-1,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
     */
}
