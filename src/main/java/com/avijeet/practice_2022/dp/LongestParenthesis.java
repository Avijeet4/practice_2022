package com.avijeet.practice_2022.dp;

import java.util.Stack;

public class LongestParenthesis {
    static int longestValidParenthesis(String str){
        int n=str.length();
        int max=0;
        int curr=0;
        Stack<Character> s=new Stack();
        int i=0;
        while(i<n){
            char c = str.charAt(i);
            if(c==')') {
                if(s.isEmpty()){
                    // neg
                    curr=0;
                    s.clear();
                }else{
                    s.pop();
                    curr+=2;
                }
            }else {
                s.push(c);
            }
            // if(s.isEmpty()){
            max=Math.max(max,curr);
            // }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(longestValidParenthesis("(()"));
        System.out.println(longestValidParenthesis(")()())"));
    }
}
