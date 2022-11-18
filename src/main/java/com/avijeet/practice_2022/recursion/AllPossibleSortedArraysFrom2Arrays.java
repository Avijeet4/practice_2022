package com.avijeet.practice_2022.recursion;

import java.util.ArrayList;
import java.util.List;

/**
A = {10, 15, 25}
B = {1, 5, 20, 30}

The resulting arrays are:
  10 20
  10 20 25 30
  10 30
  15 20
  15 20 25 30
  15 30
  25 30
**/

public class AllPossibleSortedArraysFrom2Arrays {
    static List<List<Integer>> allSortedArrays = new ArrayList<>();
    public static void findAllPossibleArr(int arr1[], int arr2[], int i, int j, boolean arr1Turn, List<Integer> res) {
        if(arr1Turn && i==arr1.length
        || !arr1Turn && j==arr2.length) {
            if(res.size()>1)
                allSortedArrays.add(res);
            return;
        }

        if(arr1Turn){
            if(res.get(res.size()-1)<=arr1[i]) {
                List<Integer> res1= new ArrayList<>(res);
                res1.add(arr1[i]);
                findAllPossibleArr(arr1, arr2, i+1, j, !arr1Turn, res1);
            }
            findAllPossibleArr(arr1, arr2, i+1, j, arr1Turn, res);
        }else {
            if(res.get(res.size()-1)<=arr2[j]) {
                List<Integer> res1= new ArrayList<>(res);
                res1.add(arr2[j]);
                findAllPossibleArr(arr1, arr2, i, j+1, !arr1Turn, res1);
            }
            findAllPossibleArr(arr1, arr2, i, j+1, arr1Turn, res);
        }
    }

    public static void allSortedArrays(int arr1[], int arr2[]){
        for(int i=0; i<arr1.length; i++){
            List<Integer> res = new ArrayList<>();
            res.add(arr1[i]);
            findAllPossibleArr(new int[]{10, 15, 25}, new int[]{1, 5, 20, 30}, i,0, false, res);
        }

    }

    public static void main(String[] args) {

//        findAllPossibleArr(new int[]{10, 15, 25}, new int[]{1, 5, 20, 30}, 0,0, false, res);
        allSortedArrays(new int[]{10, 15, 25}, new int[]{1, 5, 20, 30});
        System.out.println(allSortedArrays);
    }
}
