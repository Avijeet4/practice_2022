package com.avijeet.practice_2022.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumProblem {
    static List<List<Integer>> allSubsets = new ArrayList<>();
    public static void isSubsetSum(int arr[], int n, int sum, List<Integer> res) {
        if(sum==0){
            allSubsets.add(res);
            return;
        }
        if(n==-1){
            return;
        }

//        if(arr[n]<=sum){
//
//        }
        isSubsetSum(arr, n-1, sum, res );
        List<Integer> res1= new ArrayList<>(res);
        res1.add(arr[n]);
        isSubsetSum(arr, n-1, sum - arr[n], res1);
    }

    public static void main(String[] args) {
        isSubsetSum(new int[]{3,4,7,2,6}, 4, 9, new ArrayList<>());
        System.out.println(allSubsets);
    }
}
