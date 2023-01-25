package com.avijeet.practice_2022.array;

public class LongestConsecutiveOnes {
    static int longest1Sequence(int[] arr, int n){
        if(arr.length==0) return 0;
        int max=0, i=0,j=0;

        while(j<arr.length){
            if(arr[j]==0){
                if(n>0){
                    n--;
                    j++;
                }else{
                    i++;
                    while(i<arr.length-1 && arr[i-1]!=0){
                        i++;
                    }
                    n++;
                }
            }else{
                j++;
            }
            max=Math.max(j-i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longest1Sequence(new int[]{1,0,1,0,0,1,0,1,1,0,1,1,0,1,1,1,0,0,0,1}, 3));
    }
}
