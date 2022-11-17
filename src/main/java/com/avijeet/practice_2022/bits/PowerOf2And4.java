package com.avijeet.practice_2022.bits;

public class PowerOf2And4 {
    public static boolean isPowerOf2(int n){
        return n==0?false:(n&(n-1))==0;
    }

    public static boolean isPowerOf4(int n){
        return isPowerOf2(n) && (n & 0xAAAAAAAA)==0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(2));
        System.out.println(isPowerOf4(2));
        System.out.println(isPowerOf2(3));
        System.out.println(isPowerOf4(16));
        System.out.println(isPowerOf4(8));
    }
}
/*
d=3
                0100010010001
left shift =>   0010010001100010
                0010010001100010
right shift=>   1000100010010001

0100010010001100000
0000000000000000010
0100010010001100010

0000100010010001
1000000000000000
1000100010010001
*/
