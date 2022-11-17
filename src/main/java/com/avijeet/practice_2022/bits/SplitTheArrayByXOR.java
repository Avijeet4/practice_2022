package com.avijeet.practice_2022.bits;

public class SplitTheArrayByXOR {
    static int countGroup(int a[], int n) {
        int xs = 0;
        for (int i=0; i<n; i++)
            xs ^= a[i];
        if(xs==0){
            return (1<<(n-1))-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countGroup(new int[]{1,2,3,4,5,6,7}, 3));
    }
}
