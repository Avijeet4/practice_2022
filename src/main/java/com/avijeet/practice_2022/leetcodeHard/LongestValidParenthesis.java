package com.avijeet.practice_2022.leetcodeHard;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String str) {
        int n=str.length();
        int max=0;
        int curr=0;
        Stack<Character> s=new Stack();
        int i=0;
        while(i<n){
            if(str.charAt(i)==')' ) {
                if(s.isEmpty()||s.peek()!='('){
                    // neg
                    curr=0;
                    i++;
                    s.clear();
                    continue;
                }
                s.pop();
                curr+=2;
            }else {
                s.push('(');
            }
//            if(s.isEmpty()){
                max=Math.max(max,curr);
//            }
//            curr++;
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));
    }
}
