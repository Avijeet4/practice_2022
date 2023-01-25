package com.avijeet.practice_2022.binaryIndexedTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountNextSmallerNumbers {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int max=nums[0],min=nums[0];
        List<Integer> res=new ArrayList<>(n);
        res.add(0);
        for(int i=1;i<n;i++){
            res.add(0);
            max=Math.max(max, nums[i]);
            min=Math.min(min, nums[i]);
        }
        int bit[]=new int[max-min+1];
        for(int i=n-1;i>=0;i--){
            // bit[a[i]]+=1;
            update(bit, nums[i]-min+1, 1);
            res.set(i,sum(bit, nums[i]-min));
        }

        return res;
    }

    int sum(int bit[], int i){
        int ans=0;
        for(;i>0;i-=(i&-i)){
            ans+=bit[i];
        }
        return ans;
    }

    void update(int bit[], int i, int x){
        for(;i<bit.length;i+=(i&-i)){
            bit[i]+=x;
        }
    }

    public static void main(String[] args) {
        CountNextSmallerNumbers countNextSmallerNumbers=new CountNextSmallerNumbers();
        System.out.println(countNextSmallerNumbers.countSmaller(new int[]{8,4,9,2}));
    }
}
