package com.avijeet.practice_2022.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestSetBitDistance {
    class Cell{
        int x;
        int y;
        Cell(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        int res[][]=new int[m][n];
        Queue<Cell> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;i<n;j++){
                if(grid[i][j]==1){
                    q.add(new Cell(i, j));
                }else{
                    res[i][j]=Integer.MAX_VALUE/2;
                }
            }
        }

        while(!q.isEmpty()){
            Cell c=q.poll();
            int x[]={0,1,0,-1,1,-1,1,-1};
            int y[]={1,0,-1,0,1,1,-1,-1};
            int i=c.x;
            int j=c.y;
            for(int k=0;k<8;k++){
                if(grid[i+x[k]][j+y[k]]==0){
                    int curr=res[i][j]+Math.abs(x[k])+Math.abs(y[k]);
                    if(res[i+x[k]][ j+y[k]]> curr){
                        res[i+x[k]][ j+y[k]] = curr;
                        q.add(new Cell(i+x[k], j+y[k]));
                    }

                }
            }
        }
        return res;
    }
}
