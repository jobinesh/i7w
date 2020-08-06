package com.jobinesh.i7w.dailycoding;

import java.util.*;

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 */
public class AutoComplete {
    static class TrieNode{
        char value;
        boolean isLeaf;
        String word;
        TrieNode[] charNodeArray = new TrieNode[26];

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }

        public TrieNode[] getArray() {
            return charNodeArray;
        }

        public void setArray(TrieNode[] array) {
            this.charNodeArray = array;
        }
    }
    static class Trie {
        TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (currentNode.charNodeArray[index] == null) {
                    TrieNode node = new TrieNode();
                    node.value = ch;
                    node.isLeaf = true;
                    currentNode.charNodeArray[index] = node;
                    currentNode.isLeaf = false;
                    currentNode = node;
                } else {
                    currentNode = currentNode.charNodeArray[index];
                }
            }
            currentNode.word = word;
        }

        public String[] search(String value) {

            TrieNode currentNode = root;
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                int index = ch - 'a';
                if (currentNode.charNodeArray[index] == null) {
                    return null;
                } else {
                    currentNode = currentNode.charNodeArray[index];
                }
            }
            ArrayList<String> list = new ArrayList();
            List<String> words = new ArrayList<String>();
            Deque<TrieNode> dq = new ArrayDeque<TrieNode>();
            dq.addLast(currentNode);
            while (!dq.isEmpty()) {
                TrieNode first = dq.removeFirst();
                if (first.word != null) {
                    words.add(first.word);
                }

                for (TrieNode n : first.charNodeArray) {
                    if (n != null) {
                        dq.add(n);
                    }
                }
            }

            return words.toArray(new String[0]);
        }


    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.addWord("abc");
        trie.addWord("abd");
        trie.addWord("acd");
        System.out.println(Arrays.toString(trie.search("b")));
    }
}
