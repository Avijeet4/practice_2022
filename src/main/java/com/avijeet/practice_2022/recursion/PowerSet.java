package com.avijeet.practice_2022.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<String> getPowerSet(String str, int i, String curr) {
        int n=str.length();
        List<String> list = new ArrayList<>();
        if(i==n){
            return list;
        }
        list.add(curr);
        for(int j=i+1;j<n;j++){
            curr += str.charAt(j);
            list.addAll(getPowerSet(str, j, curr));
            curr = curr.substring(0,curr.length()-1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getPowerSet("abcd", -1, ""));
    }
}
