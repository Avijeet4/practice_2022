package com.avijeet.practice_2022.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JosephusProblem {
    public static int getSafePos(int n, int k) {
        List<Integer> list= new LinkedList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        // -1 as index starts from 0
        int die = k-1;
//        while(list.size()>1){
//            list.remove(die);
//            n = list.size();
//            // here -1 represents one dead person
//            die = (die+k-1) % n;
//        }
//        return list.get(0);
        return run(n,k,die,list);
    }

    public static int run (int n, int k, int die, List<Integer> list){
        if(list.size()==1){
            return list.get(0);
        }
        list.remove(die);
        n--;
        return run(n,k,(die+k-1)%n,list) ;
    }

    public static int runReverse (int n, int k, int die, List<Integer> list){
        if(list.size()==1){
            return list.get(0);
        }
        list.remove(die);
        n--;
        return run(n,k,(die+k-1)%n,list) ;
    }

    static int helper(int n,int k) {
        if(n==0) {
            return 0;
        }
        return (helper(n-1,k)+k) % n;
    }

    static int safePos(int n, int k) {
        int res = helper(n,k);
        return res+1;
    }

    static int deadEasy(int n, int k){
        int res=0;
        for(int i=1;i<=n;i++)
            res=(res+k)%i;
        return res+1;
    }
    public static void main(String[] args) {
        System.out.println(getSafePos(14, 3));
        System.out.println(safePos(40, 7));
        System.out.println(deadEasy(1,3));
    }
}
