package com.avijeet.practice_2022.dp;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] E) {
//        int n=E.length;
//        Arrays.sort(E, (e1,e2) -> {
////            if(e1[0] == e2[0])
////                return e2[1] - e1[1];
////            else
////                return e1[0] - e2[0];
//            return e1[0]*e1[1]-e2[0]*e2[1];
//        });
//
//        int[] dp=new int[n+1];
//        int max=0;
//        for(int i=n-1;i>0;i--){
//            max=Math.max(max, helper(E,i,dp));
//        }
////        dp[0]=1;
//        return max;
        Arrays.sort(E, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[E.length];
        int ans = 0;
        for (int[] env : E) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;

    }

    public int helper(int[][] envelopes, int n, int[] dp){
        if(n<0){
            return 0;
        }
        if(dp[n]>0){
            return dp[n];
        }
        for(int i=n-1;i>=0;i--){
            if(isValid(envelopes, n, i)) {
                dp[n] = Math.max(dp[n], helper(envelopes, i, dp));
            }
        }
        return ++dp[n];
    }

    boolean isValid(int[][] envelopes, int n, int i){
//        int mini=Math.min(envelopes[i][0],envelopes[i][1]);
//        int maxi=Math.max(envelopes[i][0],envelopes[i][1]);
//        int minn=Math.min(envelopes[n][0],envelopes[n][1]);
//        int maxn=Math.max(envelopes[n][0],envelopes[n][1]);
        return envelopes[i][0]<envelopes[n][0] && envelopes[i][1]<envelopes[n][1];
    }

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
//        russianDollEnvelopes.maxEnvelopes(new int[][]{{1,15},{7,18},{7,6},{7,100},{2,200},{17,30},{17,45},{3,5},{7,8},{3,6},{3,10},{7,20},{17,3},{17,45}});
//        russianDollEnvelopes.maxEnvelopes(new int[][]{{7,18},{7,6},{17,30},{17,45},{3,5},{7,8}});
        System.out.println(russianDollEnvelopes.maxEnvelopes(new int[][]{{17,18},{20,4},{4,3},{14,6},{16,4},{8,11},{17,11},{18,7},{20,12}}));
    }
}
