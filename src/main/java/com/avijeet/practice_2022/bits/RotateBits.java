package com.avijeet.practice_2022.bits;

public class RotateBits {
    static int last16Bits(int n32){
        return n32 & (int)(Math.pow(2,16)-1);
    }
    public static void main(String[] args) {
        int n=29;
        int d=2;
        System.out.println("Left  Shift: "+last16Bits(n<<d|n>>(16-(d%16))));
        System.out.println("Right Shift: "+last16Bits(n>>d|n<<(16-(d%16))));
    }
}
