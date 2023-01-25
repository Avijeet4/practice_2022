package com.avijeet.practice_2022.tekion;
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
public class Problem2 {
    static int calculateAmountOfWaterTrapped(int elevation[]){
        int n=elevation.length;
        int waterTrapped=0;
        int maxL[] =new int[n];
        int maxR[] =new int[n];
        maxL[0]=elevation[0];
        maxR[n-1]=elevation[n-1];

        for(int i=1;i<n;i++){
            maxL[i]=Math.max(maxL[i-1],elevation[i]);
            maxR[n-i-1]=Math.max(maxR[n-i],elevation[n-i-1]);
        }

        for(int i=0;i<n;i++){
            waterTrapped+=Math.min(maxL[i],maxR[i])-elevation[i];
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        System.out.println(calculateAmountOfWaterTrapped(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
