package com.avijeet.practice_2022.bits;

import java.util.*;

/*
A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) +
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8
*/
public class DifferentBitsSum {
    public static int cntBits(int[] A) {
        Vector<Integer> v = new Vector<>();
        Collections.sort(v, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
            Collections.reverse(v);
        v.add(0,1);
        long total=0, n=A.length;
        for(int i=0;i<32;i++){
            long bitCnt=0;
            for(int j=0;j<n;j++){
                bitCnt+=(A[j]>>i)&1;
            }
            total+=(bitCnt % (1000000007) * (n-bitCnt) % (1000000007)) % (1000000007);
        }
        total=(total*2)%(1000000007);
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, Comparator.naturalOrder());
        return (int)total;
    }

    public static void main(String[] args) {
        System.out.println(cntBits(new int[]{1,3,5}));
    }
}
