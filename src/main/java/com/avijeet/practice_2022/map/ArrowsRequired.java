package com.avijeet.practice_2022.map;

import java.util.HashMap;
import java.util.Map;

public class ArrowsRequired {
    static int arrowsRequired(int[] arr){
        Map<Integer, Integer> map=new HashMap();

        for(int i:arr){
            if(map.containsKey(i+1)){
                map.put(i+1, map.get(i+1)-1);
                if(map.get(i+1)==0){
                    map.remove(i+1);
                }
            }
            map.putIfAbsent(i,0);
            map.put(i, map.get(i)+1);
        }

        int ans=0;
        for(int v:map.values()){
            ans+=v;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(arrowsRequired(new int[]{9, 9, 8, 8, 7, 6,2}));
        System.out.println(arrowsRequired(new int[]{9, 8, 7, 4, 3, 6, 5}));
    }
}
