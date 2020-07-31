package com.jobinesh.i7w.leetcode.random;

import java.util.LinkedList;

public class RecentCounter {

    LinkedList<Integer> pings = new LinkedList();
    public RecentCounter() {
    }

    public int ping(int t) {
        pings.add(t);
        while((pings.peek()-t)>3000){
            pings.poll();
        }

        return pings.size();
    }

    public static void main(String[] args){

    }
}
