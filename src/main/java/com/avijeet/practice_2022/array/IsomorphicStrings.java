package com.avijeet.practice_2022.array;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return true;
        Map<Character, Character> map = new HashMap();
        Map<Character, Character> reverseMap = new HashMap();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)) && !reverseMap.containsKey(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
                reverseMap.put(t.charAt(i), s.charAt(i));
            }else{
                if(!map.containsKey(s.charAt(i))||map.get(s.charAt(i))!=t.charAt(i)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
