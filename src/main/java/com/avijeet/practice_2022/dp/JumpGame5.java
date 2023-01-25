package com.avijeet.practice_2022.dp;

import java.util.Arrays;

public class JumpGame5 {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int ans=0;
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        for(int i=0;i<n;i++){
            if(dp[i]==-1)
                dp[i]=helper(arr, d, i,n,dp);
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
    private int helper(int[] arr, int d, int i, int n, int[] dp) {
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans=0;
        for(int j=1;j<=d&&j+i<n&&arr[j+i]<arr[i];j++){
            if(dp[i+j]==-1){
                helper(arr,d,i+j,n,dp);
            }
            ans=Math.max(dp[i+j],ans);
        }
        for(int j=1;j<=d&&i-j>=0&&arr[i-j]<arr[i];j++){
            if(dp[i-j]==-1){
                helper(arr,d,i-j,n,dp);
            }
            ans=Math.max(dp[i-j],ans);
        }
        return dp[i]=ans+1;
    }

    public static void main(String[] args) {
        JumpGame5 jg5=new JumpGame5();
//        System.out.println(jg5.maxJumps(new int[]{7,6,5,4,3,2,1},1));
        System.out.println(jg5.maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12},2));
    }
}
