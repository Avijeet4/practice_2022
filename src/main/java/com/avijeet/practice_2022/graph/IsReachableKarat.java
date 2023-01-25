package com.avijeet.practice_2022.graph;

public class IsReachableKarat {
    /*
Given a board and an end position for the player, write a function to determine if it is possible to travel from every open cell on the board to the given end position.

board1 = [
    [ 0,  0,  0, 0, -1 ],
    [ 0, -1, -1, 0,  0 ],
    [ 0,  0,  0, 0,  0 ],
    [ 0, -1,  0, 0,  0 ],
    [ 0,  0,  0, 0,  0 ],
    [ 0,  0,  0, 0,  0 ],
]

board2 = [
    [  0,  0,  0, 0, -1 ],
    [  0, -1, -1, 0,  0 ],
    [  0,  0,  0, 0,  0 ],
    [ -1, -1,  0, 0,  0 ],
    [  0, -1,  0, 0,  0 ],
    [  0, -1,  0, 0,  0 ],
]

board3 = [
    [ 0,  0,  0,  0,  0,  0, 0 ],
    [ 0, -1, -1, -1, -1, -1, 0 ],
    [ 0, -1,  0,  0,  0, -1, 0 ],
    [ 0, -1,  0,  0,  0, -1, 0 ],
    [ 0, -1,  0,  0,  0, -1, 0 ],
    [ 0, -1, -1, -1, -1, -1, 0 ],
    [ 0,  0,  0,  0,  0,  0, 0 ],
]

board4 = [
    [0,  0,  0,  0, 0],
    [0, -1, -1, -1, 0],
    [0, -1, -1, -1, 0],
    [0, -1, -1, -1, 0],
    [0,  0,  0,  0, 0],
]

board5 = [
    [0],
]

end1 = (0, 0)
end2 = (5, 0)

Expected output:

isReachable(board1, end1) -> True
isReachable(board1, end2) -> True
isReachable(board2, end1) -> False
isReachable(board2, end2) -> False
isReachable(board3, end1) -> False
isReachable(board4, end1) -> True
isReachable(board5, end1) -> True


n: width of the input board
m: height of the input board

*/


    static int dx[] = new int[]{0, 1, 0, -1};
    static int dy[] = new int[]{1, 0, -1, 0};
    // static List<List<Integer>> getValidNextMoves(int[][] grid, int[] start){
    //   int m=grid.length;
    //   int n=grid[0].length;
    //   List<List<Integer>> result=new ArrayList<>();
    //   for(int i=0;i<4;i++){
    //     if(isValid(grid, m ,n, start[0]+dx[i], start[1]+dy[i])){
    //       List<Integer> space= new ArrayList<>();
    //       space.add(start[0]+dx[i]);
    //       space.add(start[1]+dy[i]);
    //       result.add(space);
    //     }
    //   }
    //   return result;
    // }

    static boolean allCellTraverseable(int[][] grid, int[] end) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visited[i][j] != 1) {
                    if (visited[i][j] == 2) {
                        return false;
                    } else {
                        if (dfs(grid, visited, i, j, m, n, end)) {
                            visited[i][j] = 1;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    static boolean dfs(int[][] grid, int[][] visited, int i, int j, int m, int n, int[] end) {
        if (!isValid(grid, visited, m, n, i, j)) {
            return false;
        }
        if (visited[i][j] == 1) {
            return true;
        }
        if (i == end[0] && j == end[1]) {

            return true;
        }
        boolean reachable=false;
        for (int k = 0; k < 4; k++) {
            reachable=reachable||dfs(grid, visited, i + dx[k], j + dy[k], m, n, end);
        }
        if (!reachable) {
            visited[i ][j ] = 2;
            return false;
        } else {
            visited[i][j] = 1;
        }
        return true;
    }

    static boolean isValid(int[][] grid, int[][] visited, int m, int n, int i, int j) {
        return i >= 0 && i < m
                && j >= 0 && j < n
                && grid[i][j] == 0
                && visited[i][j] != 2;
    }

    public static void main(String[] argv) {

        int[][] board1 = new int[][]{
                {0, 0, 0, 0, -1},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        int[][] board2 = new int[][]{
                {0, 0, 0, 0, -1},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
                {-1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0},
                {0, -1, 0, 0, 0},
        };

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, -1, -1, -1, -1, -1, 0},
                {0, -1, 0, 0, 0, -1, 0},
                {0, -1, 0, 0, 0, -1, 0},
                {0, -1, 0, 0, 0, -1, 0},
                {0, -1, -1, -1, -1, -1, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };

        int[][] board4 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, 0, 0, 0, 0},
        };

        int[][] board5 = new int[][]{
                {0},
        };

        int[] end1 = new int[]{0, 0};
        int[] end2 = new int[]{5, 0};

        System.out.println(allCellTraverseable(board1, end1));
//        System.out.println(allCellTraverseable(board1, end2));
//        System.out.println(allCellTraverseable(board2, end1));
//        System.out.println(allCellTraverseable(board2, end2));
//        System.out.println(allCellTraverseable(board3, end1));
//        System.out.println(allCellTraverseable(board4, end1));
//        System.out.println(allCellTraverseable(board5, end1));
    }


}
