package com.avijeet.practice_2022.graph;

public class Island {
    public static int xShape(char[][] grid)
    {
        // code here
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        boolean[][] visited=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visitIsland(grid, m, n, visited, i, j)){
                    res++;
                }

            }
        }
        return res;
    }

    static boolean visitIsland(char[][] grid, int m, int n, boolean[][] visited, int i, int j){
        if(!isValid(grid, m, n, visited, i, j)){
            return false;
        }
        // System.out.println("i: "+i+", j: "+j);
        visited[i][j]=true;
        int x[]={0,1,0,-1};
        int y[]={1,0,-1,0};

        for(int k=0;k<4;k++){
            visitIsland(grid, m, n, visited, (i+x[k]), (j+y[k]));
        }
        return true;
    }
    static boolean isValid(char[][] grid, int m, int n, boolean[][] visited, int i, int j){
        return i>=0 && i<m
                && j>=0 && j<n
                && grid[i][j]=='X'
                && !visited[i][j];
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'X','O','X'},{'O','X','O'},{'X','X','X'}};
        System.out.println(xShape(grid));
    }
}
