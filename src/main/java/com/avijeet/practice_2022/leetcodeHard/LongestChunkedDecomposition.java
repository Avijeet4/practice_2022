package com.avijeet.practice_2022.leetcodeHard;

public class LongestChunkedDecomposition {

    static public int longestDecomposition(String text) {
        int res = 0;
        int n = text.length();
        int i = 0;
        int last = 0;
        StringBuilder left=new StringBuilder(),right=new StringBuilder();
        while (i < n/2) {
            left.append( text.charAt(i));
            right.insert(0,text.charAt(n-i-1));
            if (left.toString().equals(right.toString())) {
                last = i + 1;
                res++;
                left.delete(0,left.length());
                right.delete(0,right.length());
            }
            i++;
        }
        return res*2+(last==i&&n%2==0?0:1);
    }

    public static void main(String[] args) {
        System.out.println(longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
    }
}
