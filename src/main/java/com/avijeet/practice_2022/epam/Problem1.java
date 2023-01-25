package com.avijeet.practice_2022.epam;
//There is an integer array nums sorted in ascending order (with distinct values).
//
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k  such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//
//Example -> [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
//    Input: nums = [3,5,6,7,0,1,2], target = 4
//    Output: -1

//[4,5,6,7,0,1,2]
//[0,1,2,3,4,5,6]
//m=3
//a[l]<t && t< a[m] ==> go left
//a[l]<t but t>a[m] ==> go left
//a[l]>t && t< a[m] ==> go left
//
//[4,5,6,7,8,0,1,2]
//[0,1,2,3,4,5,6,7]
//t=7
//[5,6,7,8,0,1,2,3,4]
//[0,1,2,3,4,5,6,7,8]
//

public class Problem1 {
    public static int findTargetInRotated(int[] a, int t){

        int n=a.length;
        int pivot=-1;
        for(int i=1;i<n;i++){
            if(a[i-1]>a[i]){
                pivot=i-1;
            }
        }
        int leftIndex=binarySearch(a,0,pivot,t);
        if(leftIndex!=-1){
            return leftIndex;
        }
        int rigtIndex=binarySearch(a,pivot+1,n-1,t);
        return rigtIndex;
    }

    static int binarySearch(int a[], int l, int r, int t){
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]==t){
                return m;
            }else if(a[m]<t){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(findTargetInRotated(new int[]{4,5,6,7,0,1,2},6));
        ABC abc1=ABC.getInstance();
        ABC abc2=ABC.getInstance();
        System.out.println(abc1.hashCode());
        System.out.println(abc2.hashCode());

    }
}

class ABC{
    private static ABC abc=new ABC();
    private ABC(){}
    public static ABC getInstance(){
        return abc;
    }
}
