package com.jobinesh.i7w.array;

public class MedianOf2SortedArrays {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] refArray1 = null;
        int[] refArray2 = null;
        double median=0;
        if (nums1 == null) {
            refArray1 = nums2;
            refArray2 = new int[0];
        } else if (nums2 == null) {
            refArray1 = nums1;
            refArray2 = new int[0];
        } else if (nums1.length > nums2.length) {
            refArray1 = nums1;
            refArray2 = nums2;
        } else {
            refArray1 = nums2;
            refArray2 = nums1;
        }
        int totalSize = refArray1.length + refArray2.length;
        int[] merged = new int[totalSize];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < totalSize) {
            if (refArray2.length > j && refArray1.length>i) {
                if (refArray2[j] <= refArray1[i]) {
                    merged[index] = refArray2[j];
                    j++;
                } else {
                    merged[index] = refArray1[i];
                    i++;
                }
            } else if (refArray2.length > j ){
                merged[index] = refArray2[j];
                j++;
            }else{
                merged[index] = refArray1[i];
                i++;
            }
            index++;
        }
        boolean isOddSize = (totalSize) % 2 != 0;
        if (isOddSize) {
            median = merged[totalSize/2];
        }else{
            int middle = totalSize/2;
            median = ((double)(merged[middle-1]+merged[middle]))/2;
        }
        return median;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] refArray1 = null;
        int[] refArray2 = null;
        double median=0;
        if (nums1 == null) {
            refArray1 = nums2;
            refArray2 = new int[0];
        } else if (nums2 == null) {
            refArray1 = nums1;
            refArray2 = new int[0];
        } else if (nums1.length > nums2.length) {
            refArray1 = nums1;
            refArray2 = nums2;
        } else {
            refArray1 = nums2;
            refArray2 = nums1;
        }
        int totalSize = refArray1.length + refArray2.length;
        int[] merged = new int[totalSize];
        int i = 0;
        int j = 0;
        int index = 0;
        int middle = totalSize/2;
        while (index <= middle) {
            if (refArray2.length > j && refArray1.length>i) {
                if (refArray2[j] <= refArray1[i]) {
                    merged[index] = refArray2[j];
                    j++;
                } else {
                    merged[index] = refArray1[i];
                    i++;
                }
            } else if (refArray2.length > j ){
                merged[index] = refArray2[j];
                j++;
            }else{
                merged[index] = refArray1[i];
                i++;
            }
            index++;
        }
        boolean isOddSize = (totalSize) % 2 != 0;
        if (isOddSize) {
            median = merged[middle];
        }else{
            median = ((double)(merged[middle-1]+merged[middle]))/2;
        }
        return median;
    }
    public static void main(String[] args) {
        int[] nums1 = {9};
        int[] nums2 = {3,4,11};
        System.out.println(new MedianOf2SortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
