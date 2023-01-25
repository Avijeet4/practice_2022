package com.avijeet.practice_2022.graph;


import java.util.*;

public class FindItinerary {
//    String ans;
//    public List<String> findItinerary(String[][] tickets) {
//        Map<String, List<Destination>> map = new HashMap<>();
//        for (String[] ticket : tickets) {
//            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(new Destination(ticket[1]));
//        }
//        StringBuilder path=new StringBuilder();
//        path.append("JFK");
//        dfs(map, "JFK", path, tickets.length, 0);
//        return Arrays.asList(ans.split(" "));
//    }
//
//    void dfs(Map<String, List<Destination>> map, String source, StringBuilder path, int totTick, int usedTick){
//        if(totTick==usedTick){
//            if(ans==null || ans.compareTo(path.toString())>0){
//                ans=path.toString();
//            }
//        }
//        if(!map.containsKey(source)){
//            return;
//        }
//        List<Destination> destinations=map.get(source);
//        int n=destinations.size();
//        int len=path.length();
//        for(int i=0;i<n;i++){
//            Destination dest=destinations.get(i);
//            if(dest.visited){
//                continue;
//            }
//            path.append(" ").append(dest.name);
//            destinations.get(i).visited=true;
//            dfs(map, dest.name, path, totTick, usedTick+1);
//            destinations.get(i).visited=false;
//            path.setLength(len);
//        }
//    }

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

    public static void main(String[] args) {
        FindItinerary findItinerary=new FindItinerary();

        System.out.println(findItinerary.findItinerary(new String[][]{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}}));
        System.out.println(findItinerary.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}));
        System.out.println(findItinerary.findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}));
    }
}

class Destination{
    String name;
    boolean visited;
    Destination(String name){
        this.name=name;
    }
}
