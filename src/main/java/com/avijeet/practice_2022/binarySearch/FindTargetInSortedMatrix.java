package com.avijeet.practice_2022.binarySearch;

//  1 2 3
//  4 5 6
//  7 8 9

// 4,1,3,5,6,2,5

// 5,3,5,6,-1,5,-1
public class FindTargetInSortedMatrix {
    static int[] findValueInSortedMatrix(int[][] mat, int t) {
        int m = mat.length;
        int n = mat[0].length;
        int l = 0, h = m - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mat[mid][0] <= t && mat[mid][n - 1] >= t) {
                int i = mid;
                int j = binarySearch(mat[mid], t);
                if (j == -1) {
                    return null;
                }
                int[] res = new int[2];
                res[0] = i;
                res[1] = j;
                return res;
            } else if (mat[mid][0] < t) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return null;
    }
//    O(log (m*n))
    static int binarySearch(int[] arr, int t) {
        int n = arr.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (arr[m] == t) {
                return m;
            } else if (arr[m] < t) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res[] = findValueInSortedMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 9);
        if (res == null)
            System.out.println("null");
        else
            System.out.println(res[0] + " " + res[1]);
    }
}
