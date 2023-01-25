package com.avijeet.practice_2022.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerRight {
    public static int[] nextSmallerRight(int[] a) {
        int n = a.length;
        Stack<Integer> s = new Stack();
        int nsr[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] > a[i])
                nsr[s.pop()] = i;
            s.push(i);
        }
        while (!s.isEmpty()) {
            nsr[s.pop()] = n;
        }
        return nsr;
    }

    public static void main(String[] args) {
        int nsr[] = nextSmallerRight(new int[]{6, 2, 5, 4, 5, 1, 6});
        for (int i : nsr) {
            System.out.print(i + ",");
        }
    }
}
