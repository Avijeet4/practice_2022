package com.avijeet.practice_2022.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumberLetters {
    public static List<String> letterCombinations(String digits) {
        List<Character>[] map= new ArrayList[10];
        createLetterMap(map);
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        res.add("");
        for(int i=0;i<digits.length();i++){
            List<String> newList=new ArrayList<>();
            int digit=Integer.parseInt(""+digits.charAt(i));
            for(char c:map[digit]){
                for(String s:res){
                    newList.add(s+c);
                }
            }
            res=newList;
        }
        return res;
    }

    private static void createLetterMap(List<Character>[] map){
        int c=0;
        for(int i=2;i<10;i++){
            List<Character> list=new ArrayList<>(4);
            int n=3;
            if(i==7 || i==9){
                n=4;
            }
            for(int j=0;j<n;j++){
                list.add((char)('a'+c+j));
            }
            c+=n;
            map[i]=list;
        }
    }

    public static void main(String[] args) {
        letterCombinations("2");

    }
}
