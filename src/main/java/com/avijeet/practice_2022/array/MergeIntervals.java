package com.avijeet.practice_2022.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] arr){
        List<int[]> list=new ArrayList<>();
        
        int[][] arrr=(int[][])list.toArray();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int prev=0;
        int cnt=1;
        for(int i=1;i<arr.length;i++){
            if(arr[prev][0]<=arr[i][0] && arr[prev][1]>=arr[i][0]){
                arr[prev][1]=Math.max(arr[prev][1],arr[i][1]);
                arr[i]=null;
            }else{
                cnt++;
                prev=i;
            }
        }
        int[][] res=new int[cnt][2];
        int i=0;
        for(int[] interval:arr){
            if(interval!=null){
                res[i]=interval;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr=mergeIntervals(new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        });
        for(int[] ar:arr){
            System.out.print(String.format("{%s, %s} ", ar[0], ar[1]));
        }
    }
}
