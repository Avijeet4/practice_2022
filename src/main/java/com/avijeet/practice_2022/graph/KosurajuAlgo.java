package com.avijeet.practice_2022.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosurajuAlgo {
    private  int V;   // No. of vertices
    private  ArrayList<ArrayList<Integer>> adj; //Adjacency List
//
//    //Constructor
    KosurajuAlgo(int v)
    {
        V = v;
        adj = new ArrayList<>();

        for (int i=0; i<v; ++i)
            adj.add( new ArrayList<>());
    }
//
//    //Function to add an edge into the graph
    void addEdge(int v, int w)  { adj.get(v).add(w); }
//
//    // A recursive function to print DFS starting from v
//    void DFSUtil(int v,boolean visited[])
//    {
//        // Mark the current node as visited and print it
//        visited[v] = true;
//        System.out.print(v + " ");
//
//        int n;
//
//        // Recur for all the vertices adjacent to this vertex
//        Iterator<Integer> i =adj[v].iterator();
//        while (i.hasNext())
//        {
//            n = i.next();
//            if (!visited[n])
//                DFSUtil(n,visited);
//        }
//    }
//
//    // Function that returns reverse (or transpose) of this graph
//    KosurajuAlgo getTranspose()
//    {
//        KosurajuAlgo g = new KosurajuAlgo(V);
//        for (int v = 0; v < V; v++)
//        {
//            // Recur for all the vertices adjacent to this vertex
//            Iterator<Integer> i =adj[v].listIterator();
//            while(i.hasNext())
//                g.adj[i.next()].add(v);
//        }
//        return g;
//    }
//
//    void fillOrder(int v, boolean visited[], Stack stack)
//    {
//        // Mark the current node as visited and print it
//        visited[v] = true;
//
//        // Recur for all the vertices adjacent to this vertex
//        Iterator<Integer> i = adj[v].iterator();
//        while (i.hasNext())
//        {
//            int n = i.next();
//            if(!visited[n])
//                fillOrder(n, visited, stack);
//        }
//
//        // All vertices reachable from v are processed by now,
//        // push v to Stack
//        stack.push(new Integer(v));
//    }
//
//    // The main function that finds and prints all strongly
//    // connected components
//    void printSCCs()
//    {
//        Stack stack = new Stack();
//
//        // Mark all the vertices as not visited (For first DFS)
//        boolean visited[] = new boolean[V];
//        for(int i = 0; i < V; i++)
//            visited[i] = false;
//
//        // Fill vertices in stack according to their finishing
//        // times
//        for (int i = 0; i < V; i++)
//            if (visited[i] == false)
//                fillOrder(i, visited, stack);
//
//        // Create a reversed graph
//        KosurajuAlgo gr = getTranspose();
//
//        // Mark all the vertices as not visited (For second DFS)
//        for (int i = 0; i < V; i++)
//            visited[i] = false;
//
//        // Now process all vertices in order defined by Stack
//        while (stack.empty() == false)
//        {
//            // Pop a vertex from stack
//            int v = (int)stack.pop();
//
//            // Print Strongly connected component of the popped vertex
//            if (visited[v] == false)
//            {
//                gr.DFSUtil(v, visited);
//                System.out.println();
//            }
//        }
//    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        KosurajuAlgo g = new KosurajuAlgo(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

//        System.out.println("Following are strongly connected components "+
//                "in given graph ");
        System.out.println(g.kosaraju());
    }

    public int kosaraju()
    {
        //code here
        boolean[] visited =new boolean[V];
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                fillDfsOrder(adj, visited, s, i);
            }
        }
        ArrayList<ArrayList<Integer>> adjNew = transpose(V, adj);
        visited =new boolean[V];
        int cnt=0;
        while(!s.isEmpty()){
            int u=s.pop();
            if(!visited[u]){
                dfsUtil(adjNew, visited, u);
                cnt++;
            }
        }
        return cnt;
    }

    void fillDfsOrder(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> s, int u){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                fillDfsOrder(adj, visited, s, v);
            }
        }
        s.push(u);
    }

    ArrayList<ArrayList<Integer>> transpose(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> adjNew =new ArrayList<>();
        for(int i=0;i<V;i++)
            adjNew.add(new ArrayList<>());

        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                adjNew.get(v).add(u);
            }
        }
        return adjNew;
    }

    void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int u){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfsUtil(adj, visited, v);
            }
        }
    }
}
