package com.avijeet.practice_2022.tekion;
//Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//        For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//[73, 74, 75, 71, 69, 72, 76, 73]
//[0,  1,  2,  3,  4,  5,  6,  7]
//[1,  1,   4,  2,  1,  1,  0,  0]

//S: 2 5

import java.util.Stack;

//res: [1,1,0,2,1,0,0,0]
public class Problem1 {
    static int[] nextWarmerDays(int[] temperatures){
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
             if(!s.isEmpty() && temperatures[s.peek()]<temperatures[i]) {
                 int j = s.peek();
                 while (!s.isEmpty() && temperatures[j] < temperatures[i]) {
                     res[j] = i - j;
                     s.pop();
                     if(!s.isEmpty())
                         j=s.peek();
                 }
             }
             s.push(i);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] res1=nextWarmerDays(new int[]{73, 74, 75, 71, 69, 78, 76, 73});
        for(int r:res1){
            System.out.print(r+" ");
        }
    }
}
