package com.avijeet.practice_2022.bits;

public class SwapAllOddAndEvenBits {
    public static int swapBits(int n) {
        int evenPosBits = (n&0xAAAAAAAA);
        int oddPosBits = (n&(0xAAAAAAAA>>1));
        return (evenPosBits>>1)|(oddPosBits<<1);
    }

    public static void main(String[] args) {
        System.out.println(swapBits(23));
    }
}
