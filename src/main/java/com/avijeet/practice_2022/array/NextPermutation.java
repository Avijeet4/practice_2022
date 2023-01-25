package com.avijeet.practice_2022.array;

public class NextPermutation {
    public static void nextPermutation(int[] a) {
        int n=a.length;
        int i=n-1;
        int max=a[i];
        while(i>0 && a[i-1]>=a[i]){
            max=Math.max(max, a[i-1]);
            i--;
        }
        if(i==0){
            int mod=max+1;
            for(;i<n;i++){
                a[i]+=(a[n-i-1]%mod)*mod;
            }
            for(i=0;i<n;i++){
                a[i]/=mod;
            }
        }else{
            i--;
            int temp=a[i];
            while(i<n-1){
                a[i]=a[i+1];
                i++;
            }
            a[i]=temp;
        }
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,2,3};
        int b[]=new int[]{3,2,1};
        int c[]=new int[]{1,1,5};
        nextPermutation(a);
        nextPermutation(b);
        nextPermutation(c);
        print(a);
        print(b);
        print(c);

    }

    private static void print(int a[]){
        for (int n:a){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
