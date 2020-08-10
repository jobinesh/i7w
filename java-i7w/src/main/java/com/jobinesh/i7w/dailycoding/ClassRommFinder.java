package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class ClassRommFinder {
    public int findClassRooms(int[][] timeInetrvals){
        int rooms=0;
        Arrays.sort(timeInetrvals, Comparator.comparing((intervals)->intervals[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(int i=0;i<timeInetrvals.length;i++ ) {
            if(priorityQueue.isEmpty()){
                priorityQueue.offer( timeInetrvals[i][1]);
                rooms++;
            }else if( priorityQueue.peek()<timeInetrvals[i][0]){
                priorityQueue.poll();
                priorityQueue.offer(timeInetrvals[i][1]);
            }else{
                rooms++;
                priorityQueue.offer(timeInetrvals[i][1]);
            }
        }
        return rooms;
    }

    public static void main(String[] args){
        int[][] timeInetvals= new int[][] {{30, 75}, {0, 50}, {60, 150}};
      int result = new ClassRommFinder().findClassRooms(timeInetvals);
      System.out.println(result );
    }
}
