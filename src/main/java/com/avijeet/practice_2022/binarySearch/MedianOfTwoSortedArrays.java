package com.avijeet.practice_2022.binarySearch;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int l=0,h=m;
        while(l<=h){
            int m1=(l+h)/2; //1,2
            int m2=(m+n+1)/2-m1;//1,0
//num1:{1,2}. num2:{3,4}
            int L1=m1==0?Integer.MIN_VALUE:nums1[m1-1]; //2
            int L2=m2==0?Integer.MIN_VALUE:nums2[m2-1]; //-INF
            int R1=m1==m?Integer.MAX_VALUE:nums1[m1];   //2
            int R2=m2==n?Integer.MAX_VALUE:nums2[m2];   //4

            if(L1>R2) h=m1-1;
            else if(L2>R1) l=m1+1;
            else {
                if((m+n)%2==0){
                    return ((double)Math.max(L1,L2)+Math.min(R1,R2))/2;
                }else{
                    return Math.max(L1,L2);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{ 2,3,4,5,6,8,9,10,11,12},new int[]{-1, -2}));
    }
}
