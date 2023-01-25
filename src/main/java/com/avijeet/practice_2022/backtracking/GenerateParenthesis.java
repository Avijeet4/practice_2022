package com.avijeet.practice_2022.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {

        List<String> res=new ArrayList<>();
        Set<String> set = new HashSet<>();
        if(n==0){
            return res;
        }

        if(n==1){
            res.add("()");
            return res;
        }

        List<String> children=generateParenthesis(n-1);
        for(String child:children){
            set.add("("+child+")");
            set.add("()"+child);
            set.add(child+"()");
        }
        res.addAll(set);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
