package com.avijeet.practice_2022.math;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb=new StringBuilder();
        String sign=((numerator<0==denominator<0)||(numerator==0))?"":"-";
        Map<Long, Integer> map=new HashMap();
        long n=Math.abs((long)numerator);
        long d=Math.abs((long)denominator);
        sb.append(sign);
        sb.append(n/d);
        long r=n%d;
        if(r==0){
            return sb.toString();
        }
        sb.append(".");
        while(!map.containsKey(r)){
            map.put(r,sb.length());
            sb.append(10*r/d);
            r=10*r%d;
        }
        // if(r==0){
        //     return sb.toString();
        // }
        sb.insert(map.get(r), "(");
        sb.append(")");


        return sb.toString().replace("(0)","");
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4,333));
    }
}
