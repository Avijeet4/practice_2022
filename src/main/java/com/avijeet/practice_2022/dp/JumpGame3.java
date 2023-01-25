package com.avijeet.practice_2022.dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGame3 {
    Map<Integer, Boolean> memo=new HashMap();
    public boolean canReach(int[] arr, int start) {
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        int n=arr.length;
        if(start<0||start>=n){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        memo.put(start, canReach(arr, start-arr[start]) || canReach(arr, start+arr[start]));
        return memo.get(start);
    }

    public static void main(String[] args) {
        JumpGame3 jumpGame3=new JumpGame3();
        System.out.println(jumpGame3.canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(jumpGame3.canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(jumpGame3.canReach(new int[]{3,0,2,1,2}, 2));
    }
}
