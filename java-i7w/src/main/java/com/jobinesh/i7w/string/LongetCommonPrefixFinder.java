package com.jobinesh.i7w.string;

public class LongetCommonPrefixFinder {
    public String longestCommonPrefix(String[] args) {
        if(args.length==0){
            return "";
        }
        StringBuilder commonPrefix = new StringBuilder();
        commonPrefix.append(args[0]);
        for (var i = 1; i < args.length; i++) {
            char[] toCheck = args[i].toCharArray();
            for (var j = 0; j < commonPrefix.length(); j++) {
               if(j<toCheck.length && commonPrefix.charAt(j) == toCheck[j]){
                    continue;
               }else{
                   if( j==0){
                       return "";
                   }else {
                       commonPrefix= new StringBuilder( commonPrefix.substring(0, j ));
                   }
               }
            }
        }
        return commonPrefix.toString();
    }

    public static void main(String[] arg) {
        System.out.println("Result: "+new LongetCommonPrefixFinder().longestCommonPrefix( new String[]{"kfioower","floow","floight"}) );
    }
}
