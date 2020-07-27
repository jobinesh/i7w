package com.jobinesh.i7w.array;

public class MaxAreaCalc {
    public int maxArea(int[] heights) {
        int size=0;
        int upper = heights.length-1;
        int lower = 0;
        while(lower < upper){
            int height = heights[lower] < heights[upper]?heights[lower]:heights[upper];
            int width= upper-lower;
            int currentSize = height * width;
            if(currentSize>size){
                size=currentSize;
            }
            if( heights[lower]> heights[upper]){
                upper --;
            }else {
                lower++;
            }
        }
        return size;
    }

    public static void main(String[] args){
        int[] heights= {1,8,6,2,5,4,8,3,7};

        //int[] heights={2,3,4,5,18,17,6};
        System.out.println("Size: "+ new MaxAreaCalc().maxArea(heights) );
    }
}
