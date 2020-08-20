package com.jobinesh.i7w.dailycoding;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minQueue = new PriorityQueue();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue(Comparator.reverseOrder());
    public MedianFinder() {

    }

    public void addNum(int num) {
       if(minQueue.size()==maxQueue.size()){
           maxQueue.offer(num);
           minQueue.offer(maxQueue.poll());
       }else{
           minQueue.offer(num);
           maxQueue.offer(minQueue.poll());
       }
    }

    public double findMedian() {
       if(minQueue.size()==maxQueue.size() ){
          return ((double)( minQueue.peek()+maxQueue.peek()))/2;
        }else{
            return minQueue.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        //obj.addNum(6);
        //obj.addNum(7);
        double param_2 = obj.findMedian();
        System.out.println(param_2 );
    }
}
