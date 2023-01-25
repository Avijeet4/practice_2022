package com.avijeet.practice_2022.stack;

import java.util.Stack;

public class NextSmallerLeft {
    static public int[] nextSmallerLeft(int[] a){
        int n=a.length;
        Stack<Integer> s=new Stack();
        int nsl[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && a[s.peek()]>a[i])
                nsl[s.pop()]=i;
            s.push(i);
        }
        while(!s.isEmpty()){
            nsl[s.pop()]=-1;
        }
        return nsl;
    }

    public static void main(String[] args) {
        for(int i:nextSmallerLeft(new int[]{6,2,5,4,5,1,6}))
            System.out.print(i+" ");
    }
}
