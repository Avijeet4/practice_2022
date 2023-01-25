package com.avijeet.practice_2022.graph;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int l=word.length();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
//                    board[i][j]='@';
                    if(wordSearch(board, word, m,n,l,i,j,0))
                        return true;
//                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }

    public boolean wordSearch(char[][] board, String word, int m, int n, int l, int i, int j, int k){
        if(k==l) return true;
        if(!isValid(board, word, m,n,l,i,j,k)){
            return false;
        }
        board[i][j]='@';
        boolean result = wordSearch(board, word, m,n,l,i+1,j,k+1)
                || wordSearch(board, word, m,n,l,i,j+1,k+1)
                || wordSearch(board, word, m,n,l,i-1,j,k+1)
                || wordSearch(board, word, m,n,l,i,j-1,k+1);
        board[i][j]=word.charAt(k);
        return result;
    }

    public boolean isValid(char[][] board, String word, int m, int n, int l, int i, int j, int k){
        return i>=0 && i<m
                && j>=0 && j<n
                && k<l
                && board[i][j]==word.charAt(k);
    }

    public static void main(String[] args) {
        WordSearch wordSearch=new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCCED"));
    }
}
