package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;
import java.util.List;

/**
 * Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.
 *
 * The input list is not necessarily ordered in any way.
 *
 * For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
 */
public class DC77OverlappingIntervals {
    public int[][] merge(int[][] intervals){
        List intervalList = Arrays.asList( intervals);
        for(int i=0;i<intervals.length;i++){
            for(int j=i+1;j<intervals.length;j++){
                if( intervals[i][0]<= intervals[j][0] &&  intervals[i][1]>=  intervals[j][1]){
                    intervals[j][0] = Integer.MIN_VALUE;
                    intervals[j][1] = Integer.MIN_VALUE;
                }else if( intervals[i][0]>= intervals[j][0] &&  intervals[i][1]<=  intervals[j][1]){
                    intervals[i][0] = Integer.MIN_VALUE;
                    intervals[i][1] = Integer.MIN_VALUE;
                }
            }
        }
        return intervals;
    }
    public static void main(String[] args){
        int[][] intervals = new int[][]{ {1, 3}, {5, 8}, {4, 10}, {20, 25}};
         int[][] merged = new DC77OverlappingIntervals().merge( intervals);
         System.out.println( "Merged "+  Arrays.deepToString( merged ));
    }
}
