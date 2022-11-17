package com.avijeet.practice_2022.bits;

import java.util.ArrayList;
import java.util.List;

/*
* Bit Rotation: A rotation (or circular shift) is an operation similar to a shift except that the bits that fall off at one end are put back to the other end.

Input : a = 8, b = 1

Output : yes
Explanation : Representation of a = 8 : 0000 0000 0000 0000 0000 0000 0000 1000 ,Representation of b = 1 : 0000 0000 0000, 0000 0000 0000 0000 0001. If we rotate a by 3 units right we get b, hence answer is yes.

Input : a = 122, b = 2147483678
Output : yes
Explanation :Representation of a = 122        : 0000 0000 0000 0000 0000 0000 0111 1010,Representation of b = 2147483678 : 1000 0000 0000 0000 0000 0000 0001 1110, If we rotate a by 2 units right we get b, hence answer is yes.
*/
public class IsBitRotations {
    public static boolean isRotation(long a, long b){
        long a64 = a | (a<<32);

        while(a64>=b){
//            System.out.println("a64          : "+ getBits(a64));
//            System.out.println("unsigned(a64): "+ getBits(unsigned(a64)));
//            System.out.println("b            : " + getBits(b));
            if(unsigned(a64)==b)
                return true;
            a64 >>= 1;
        }
        return false;
    }
    public static void main(String[] args) {
        long x = 122;
        long y = 2147483678L;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2l,31l));
//
//        System.out.println("Integer.MAX_VALUE             : "+ getBits(Integer.MAX_VALUE));
//        System.out.println("(2*(long)Integer.MAX_VALUE +1): "+ getBits((2*(long)Integer.MAX_VALUE + 1)));
//
//        System.out.println("X: "+ getBits(x));
//        System.out.println("Y: "+ getBits(y));
        System.out.println(isRotation(x,y));
    }

    public static List<Long> getBits(long n) {
        List<Long> bits = new ArrayList<>();
        while(n>0){
            bits.add(0,n%2l);
            n=n/2;
        }
        return bits;
    }
    static long unsigned(long x64){
        return x64 & (2*(long)Integer.MAX_VALUE +1);
    }
}
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 26 27 28 29 30 31 32
//010111100000000000000000000000000101111
//000000001111000000000000000000000000001
