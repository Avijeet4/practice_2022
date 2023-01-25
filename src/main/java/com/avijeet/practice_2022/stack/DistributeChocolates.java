package com.avijeet.practice_2022.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DistributeChocolates {
    static int[] distributeChocolates(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> s=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        boolean isStack=true;
//        Integer prevInd=null;
        for(int i=1;i<n;i++){
            if(arr[i-1]==arr[i]){
                res[i]=res[i-1];
            }else
            if(arr[i-1]<arr[i]){
                if(!isStack){
                    while(!q.isEmpty()){
                        res[q.peek()]=Math.max(res[q.peek()], q.size()+1);
                        q.poll();
                    }
                }
                isStack=true;
                s.push(i-1);
                res[i]=Math.max(res[i], s.size()+1);
            }else {
                if(isStack){
                    while(!s.isEmpty()){
                        res[s.peek()]=Math.max(res[s.peek()], s.size());
                        s.pop();
                    }
                }
                isStack=false;
                q.add(i-1);
                res[i]=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] chocolates=distributeChocolates(new int[]{1,2,9,7,6,4,5,5,5,6});
        for (int chocolate:chocolates){
            System.out.print(chocolate+" ");
        }
        System.out.println();
        chocolates=distributeChocolates(new int[]{3,4,5,6,7,2,1,5,6});
        for (int chocolate:chocolates){
            System.out.print(chocolate+" ");
        }
    }
}
//1 2 9 7 6 4 5 5 5 6
//3 4 5 6 7 2 1 5 6