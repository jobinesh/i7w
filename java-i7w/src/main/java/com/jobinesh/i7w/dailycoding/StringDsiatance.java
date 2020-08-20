package com.jobinesh.i7w.dailycoding;

public class StringDsiatance {
    public int calcEditDistance(String s1, String s2, int len1, int len2) {
        int[][] dist = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if( i==0){
                    dist[i][j]=j;
                }else  if( j==0){
                    dist[i][j]=i;
                }else if( s1.charAt(i-1)==s2.charAt(j-1)){
                    dist[i][j]=dist[i-1][j-1];
                }else{
                    dist[i][j]= min( 1+ dist[i][j-1],
                            1+dist[i-1][j],
                            1+dist[i-1][j-1]);
                }
            }
        }
        return dist[len1][len2];
    }
    public int calcEditDistance1(String s1, String s2, int len1, int len2) {
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
            return calcEditDistance1(s1, s2, len1 - 1, len2 - 1);
        }
        return min(1 + calcEditDistance1(s1, s2, len1 , len2-1),
                1 + calcEditDistance1(s1, s2, len1-1, len2 ),
                1 + calcEditDistance1(s1, s2, len1 - 1, len2 - 1));
    }

    private int min(int a1, int a2, int a3) {
        int min = Math.min(a1, a2);
        min = Math.min(min, a3);
        return min;
    }

    public int distance(String str1, String str2) {
        int dist = calcEditDistance(str1, str2, str1.length(), str2.length());
        return dist;
    }
//"dinitrophenylhydrazine"
 //       "benzalphenylhydrazone"
    public static void main(String[] args) {
        String str1 = "dinitrophenylhydrazine";
        String str2 =  "benzalphenylhydrazone";
        System.out.println(new StringDsiatance().distance(str1, str2));
    }
}
