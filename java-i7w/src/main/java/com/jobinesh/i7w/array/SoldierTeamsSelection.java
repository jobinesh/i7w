package com.jobinesh.i7w.array;

/**
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * <p>
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * <p>
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 */
public class SoldierTeamsSelection {
    public int numTeams(int[] rating) {
        int teams=0;
        if(rating ==null){
            return 0;
        }
        for(int i=0;i<rating.length;i++){
            for(int j=i+1;j<rating.length;j++){
                for(int k=j+1;k<rating.length;k++){
                    if( rating[i]< rating[j] && rating[j]<rating[k]){
                        teams++;
                    }
                    if( rating[i]> rating[j] && rating[j]>rating[k]){
                        teams++;
                    }

                }
            }
        }
        return teams;
    }

    public static void main(String[] args) {
        int[]  rating = {1,2,3,4};
        System.out.println( new SoldierTeamsSelection().numTeams(rating) );
    }
}
