package com.jobinesh.i7w.array;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 *
 * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
 *
 * Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int count =0;
        if(heights == null || heights.length==0){
            return 0;
        }
        int[] originalHeights=new int[heights.length];
        System.arraycopy(heights, 0, originalHeights, 0,heights.length);
        for(int i=0; i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++)
            if(heights[i]>heights[j]){
                int tmp= heights[i];
                heights[i] =heights[j];
                heights[j]=tmp;
            }
        }
        for(int k=0;k<heights.length;k++){
            if(heights[k] != originalHeights[k] ){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
       int heights[] = {1,2,3,4,5};
       System.out.println( new HeightChecker().heightChecker(heights ));
    }
}
