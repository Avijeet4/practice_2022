package com.avijeet.practice_2022.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    static public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length;
        int res[]=new int[n-k+1];
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return a[y]-a[x];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(i);
        }
        res[0]=a[pq.peek()];
        for(int i=k;i<n;i++){
//            pq.remove(i-k);
            pq.offer(i);
            res[i-k+1]=a[pq.peek()];
        }
        System.out.println(pq);
        return res;
    }

    public static void main(String[] args) {
        int res[]=maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for (int r:res){
            System.out.print(r+", ");
        }
    }
}
