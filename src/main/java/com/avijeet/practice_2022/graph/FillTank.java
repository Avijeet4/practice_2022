package com.avijeet.practice_2022.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FillTank {
    public static void main(String[] args) {
        try (BufferedReader read = new BufferedReader(new FileReader("/Users/avijeet/Documents/GitHub/practice_2022/src/main/java/com/avijeet/practice_2022/graph/testData"))) {

            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String input_line[] = read.readLine().trim().split("\\s+");
                int N = Integer.parseInt(input_line[0]);
                int S = Integer.parseInt(input_line[1]);
                String input_line1[] = read.readLine().trim().split("\\s+");
                int cap[] = new int[N];
                for (int i = 0; i < N; i++) {
                    cap[i] = Integer.parseInt(input_line1[i]);
                }
                int Edges[][] = new int[N - 1][2];
                for (int i = 0; i < N - 1; i++) {
                    String input_line2[] = read.readLine().trim().split("\\s+");
                    Edges[i][0] = Integer.parseInt(input_line2[0]);
                    Edges[i][1] =
                            Integer.parseInt(input_line2[1]);
                }
                FillTank ob = new FillTank();
                long ans = ob.minimum_amount(Edges, N, S, cap);
                System.out.println(ans);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    long availableWater = (long) 1e18;
    long minimum_amount(int [][]Edges, int N, int S, int []Cap){
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[N];
        for(int i=0;i<N;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<Edges.length;i++){
            adj.get(Edges[i][0]-1).add(Edges[i][1]-1);
            adj.get(Edges[i][1]-1).add(Edges[i][0]-1);
        }

        return dfs(adj, N, S-1, Cap, visited, S-1);
    }
    long dfs(List<List<Integer>> adj, int N, int S, int []Cap, boolean[] visited, int start){
        if(visited[S]){
            return 0;
        }
        // System.out.println(S+" "+Cap[S]);
        visited[S]=true;
        long max=0;
        long childCnt=adj.get(S).size();
        if(S==start){
            childCnt-=1;
        }
        for(int v:adj.get(S)){
//            if(!visited[v]) {
                long curr = dfs(adj, N, v, Cap, visited, start);
                if (curr == -1) {
//                    System.out.println("Alert");
                    return -1;
                }
                max = Math.max(max, curr);
//            }
        }

        long ans=max*childCnt + Cap[S];
        if(ans>availableWater) {
            System.out.println("Alert");
            return -1;
        }
        // System.out.println(S+ ",  childCnt: "+childCnt+ ", max:"+ max+ ", ans:"+ans);
        return ans;
    }

}
