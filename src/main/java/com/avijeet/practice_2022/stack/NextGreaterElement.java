package com.avijeet.practice_2022.stack;


import java.util.Stack;

// 4,1,3,5,6,2,5
// 5,3,5,6,-1,5,-1
public class NextGreaterElement {
    static int[] nextGreaterElement(int[] arr){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                arr[s.pop()]=arr[i];
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            arr[s.pop()]=-1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[]=nextGreaterElement(new int[]{4,1,3,5,6,2,5});
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
