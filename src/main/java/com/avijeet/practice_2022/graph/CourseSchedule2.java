package com.avijeet.practice_2022.graph;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> set =new HashSet();
        Queue<Integer> q=new LinkedList();
        List<Integer>[] adj=new List[numCourses];
        int[] indegree=new int[numCourses];
        int res[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            set.add(prerequisites[i][1]);
            indegree[prerequisites[i][0]]++;
            if(adj[prerequisites[i][1]]==null){
                adj[prerequisites[i][1]]=new ArrayList<>();
            }
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0;i<prerequisites.length;i++){
            set.remove(prerequisites[i][0]);
        }
        if(set.size()==0 && prerequisites.length!=0){
            return new int[0];
        }
        for(int i:set){
            q.add(i);
        }
//        set.clear();
        int i=0;
        while(!q.isEmpty()){
            int c=q.poll();
            res[i]=c;
            set.add(c);
            if(adj[c]==null)
                continue;
            for(int j:adj[c]){
                if(--indegree[j]==0) {
                    if (set.contains(j))
                        return new int[0];
                    q.add(j);
                }

            }
            i++;
        }
        if(i<numCourses){
            for(int j=0;j<numCourses;j++){
                if(indegree[j]>0){
                    return new int[0];
                }
                if(adj[j]==null){
                    res[i]=j;
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CourseSchedule2 cs2=new CourseSchedule2();
        int res[]=cs2.findOrder(3,new int[][]{{1,0},{1,2},{0,1}});
//                cs2.findOrder(1,new int[][]{});
//                cs2.findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
