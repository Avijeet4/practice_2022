package com.avijeet.practice_2022.dp;

import java.util.HashMap;
import java.util.Map;
//128. Longest Consecutive Sequence
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] a) {
        int n = a.length;
        int ans = 0, curr = 0;
        if (n < 1000) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(a[i], null);
            }
            for (int i : map.keySet()) {
                ans = Math.max(ans, helper(a, i, map));
            }
        } else {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, a[i]);
                max = Math.max(max, a[i]);
            }
            boolean map[] = new boolean[max - min + 1];
            for (int i : a) {
                map[i - min] = true;
            }
            for (boolean isNumber : map) {
                if (isNumber) {
                    curr++;
                } else {
                    ans = Math.max(curr, ans);
                    curr = 0;
                }
            }
            ans = Math.max(curr, ans);
        }
        return ans;
    }

    public int helper(int[] a, int i, Map<Integer, Integer> map) {
        if (!map.containsKey(i)) {
            return 0;
        }
        if (map.get(i) != null) {
            return map.get(i);
        }
        map.put(i, helper(a, i + 1, map) + 1);
        return map.get(i);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
