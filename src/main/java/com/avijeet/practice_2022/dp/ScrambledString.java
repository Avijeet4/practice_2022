package com.avijeet.practice_2022.dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
    public static String isScrambleHelper(String s1, String s2, int i, int j, Map<String, String> memo){
        if(i>j){
            return "";
        }
        if(memo.containsKey(i+"--"+j)){
            return memo.get(i+"--"+j);
        }
        String orig=s1.substring(i,j+1);
        String pattern=s2.substring(i,j+1);
        if(orig.equals(pattern)){
            return orig;
        }
        for(int k=i;k<j;k++){
            String left=s1.substring(i,k+1);
            String right=s1.substring(k+1, j+1);
            String swap=s1.substring(0,i)+right+left;
            if(j+1<s1.length()){
                swap+=s1.substring(j+1);
            }
            if((right+left).equals(pattern)){
                memo.put(i+"--"+j, right+left);
                return right+left;
            }
            left=isScrambleHelper(s1,s2,i,k, memo);
            right=isScrambleHelper(s1,s2,k+1,j,memo);
            if((left+right).equals(pattern)){
                memo.put(i+"--"+j, left+right);
                return left+right;
            }
            if((right+left).equals(pattern)){
                memo.put(i+"--"+j, right+left);
                return right+left;
            }

            left=isScrambleHelper(swap,s2,i,k, memo);
            right=isScrambleHelper(swap,s2,k+1,j,memo);
            if((left+right).equals(pattern)){
                memo.put(i+"--"+j, left+right);
                return left+right;
            }
            if((right+left).equals(pattern)){
                memo.put(i+"--"+j, right+left);
                return right+left;
            }
        }
        memo.put(i+"--"+j, orig);
        return orig;
    }

    public static void main(String[] args) {
        Map<String, String> memo=new HashMap<>();
        System.out.println(isScrambleHelper("abc","cba",0,2,memo));
    }
}
