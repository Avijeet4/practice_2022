package com.avijeet.practice_2022.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result=new ArrayList<>();
    StringBuilder commonString=new StringBuilder();
    public List<List<String>> solveNQueens(int n) {
        generateStringBuilder(n);
        // for(int i=0;i<n;i++){
        List<String> curr=new ArrayList<>();
        dfs(0,curr,n);
        return result;

        // }
    }
    public void dfs(int i, List<String> curr, int n){
        if(i==n){
            result.add(new ArrayList<>(curr));
            return;
        }
        StringBuilder sb=new StringBuilder(commonString);
        for(int j=0;j<n;j++){
//            sb.replace(j,j+1,"Q");
            if(isValid(i,j,curr, n)){
                sb.replace(j,j+1,"Q");
                curr.add(sb.toString());
                dfs(i+1,curr, n);
                curr.remove(curr.size()-1);
                sb.replace(j,j+1,".");
            }
        }

        // return true;
    }
    boolean isValid(int i, int j, List<String> curr, int n){
        if(i<0 || i>=n || j<0 || j>=n ){
            return false;
        }
        int ii=i-1, jj=j;

        while(ii>=0 && jj>=0){
            if(curr.get(ii).charAt(jj)=='Q'){
                return false;
            }
            ii--;
        }
        ii=i-1; jj=j-1;
        while(ii>=0 && jj>=0){
            if(curr.get(ii).charAt(jj)=='Q')
                return false;
            ii--;jj--;
        }
        ii=i-1; jj=j+1;
        while(ii>=0 && jj<n){
            if(curr.get(ii).charAt(jj)=='Q')
                return false;
            ii--;jj++;
        }
        return true;
    }
    public void generateStringBuilder(int n){
        for(int i=0;i<n;i++){
            commonString.append(".");
        }
    }

    public static void main(String[] args) {
        NQueens qQueens=new NQueens();
        System.out.println(qQueens.solveNQueens(4));
    }
}
