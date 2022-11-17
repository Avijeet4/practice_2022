package com.avijeet.practice_2022.bits;

/*
    Input: arr1[] = {16, 12, 8, 4}
    Output: 8
    Explanation: 8 AND12 will give us the maximum value 8
        16: 10000
        12: 01100
        8 : 01000
        4 : 00100
    Input: arr1[] = {4, 8, 16, 2}
    Output: 0
*/
public class MaximumAndValue {
    public static int countSetBits(int pattern, int arr[]) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pattern == (pattern & arr[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    // Function for finding maximum and value pair
    public static int maxAND(int arr[]) {
        // Complete the function
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int cnt = countSetBits(res | 1 << i, arr);
            if (cnt > 1)
                res |= 1 << i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxAND(new int[]{4,2,8,16}));
    }
}
