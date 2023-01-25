package com.avijeet.practice_2022.segmentTree;

import java.util.*;

public class SkylineProblem {
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        Set<Integer> pos=new TreeSet<>();
//        Map<Integer, Integer> positionToIndex=new HashMap();
//        Map<Integer, Integer> indexToPosition=new HashMap();
//        List<List<Integer>> result=new ArrayList();
//        int index=0;
//        for(int[] building:buildings){
//            pos.add(building[0]);
//            pos.add(building[1]);
//        }
//
//        for(int p:pos){
//            positionToIndex.put(p,index);
//            indexToPosition.put(index,p);
//            index++;
//        }
//
//        SegmentTreeNode root = new SegmentTreeNode(0,pos.size()-1);
//        root.init(root,0,pos.size()-1);
//
//        for(int[] building:buildings){
//            root.update(root, positionToIndex.get(building[0]), positionToIndex.get(building[1])-1, building[2]);
//        }
//
//        List<SegmentTreeNode> list=new ArrayList();
//        dfs(list, root);
//        for(int i=0;i<list.size();i++){
//            SegmentTreeNode curr = list.get(i);
//            result.add(Arrays.asList(indexToPosition.get(curr.start), curr.height));
//            while(i+1<list.size() && list.get(i+1).height == curr.height){
//                i++;
//            }
//        }
//        return result;
//    }
//
//    void dfs(List<SegmentTreeNode> list, SegmentTreeNode root){
//        if(root==null)
//            return;
//        if(root.start==root.end){
//            list.add(root);
//            return;
//        }
//        dfs(list, root.left);
//        dfs(list, root.right);
//    }
public List<List<Integer>> getSkyline(int[][] buildings) {
    final int n = buildings.length;
    if (n == 0)
        return new ArrayList<>();
    if (n == 1) {
        final int left = buildings[0][0];
        final int right = buildings[0][1];
        final int height = buildings[0][2];
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(left, height)));
        ans.add(new ArrayList<>(Arrays.asList(right, 0)));
        return ans;
    }

    List<List<Integer>> leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
    List<List<Integer>> rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));
    return merge(leftSkyline, rightSkyline);
}

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0; // left's index
        int j = 0; // right's index
        int leftY = 0;
        int rightY = 0;

        while (i < left.size() && j < right.size())
            // choose the point with smaller x
            if (left.get(i).get(0) < right.get(j).get(0)) {
                leftY = left.get(i).get(1); // update the ongoing leftY
                addPoint(ans, left.get(i).get(0), Math.max(left.get(i++).get(1), rightY));
            } else {
                rightY = right.get(j).get(1); // update the ongoing rightY
                addPoint(ans, right.get(j).get(0), Math.max(right.get(j++).get(1), leftY));
            }

        while (i < left.size())
            addPoint(ans, left.get(i).get(0), left.get(i++).get(1));

        while (j < right.size())
            addPoint(ans, right.get(j).get(0), right.get(j++).get(1));

        return ans;
    }

    private void addPoint(List<List<Integer>> ans, int x, int y) {
        if (!ans.isEmpty() && ans.get(ans.size() - 1).get(0) == x) {
            ans.get(ans.size() - 1).set(1, y);
            return;
        }
        if (!ans.isEmpty() && ans.get(ans.size() - 1).get(1) == y)
            return;
        ans.add(new ArrayList<>(Arrays.asList(x, y)));
    }
}

class SegmentTreeNode{
    int start, end, height;
    SegmentTreeNode left, right;

    SegmentTreeNode(int start, int end){
        this.start=start;
        this.end=end;
        this.height=0;
    }

    void init(SegmentTreeNode root, int start, int end){
        if(root==null || root.start >= root.end){
            return;
        }
        int mid = (start+end)/2;
        root.left = new SegmentTreeNode(start, mid);
        root.right = new SegmentTreeNode(mid+1, end);
        init(root.left, start, mid);
        init(root.right, mid+1, end);
    }

    public void update(SegmentTreeNode root, int start, int end, int height){
        if(root.start>end || root.end<start){
            return;
        }

        if(root.start==root.end){
            root.height = Math.max(root.height, height);
            return;
        }

        update(root.left, start, end, height);
        update(root.right, start, end, height);
        root.height = Math.max(root.left.height, root.right.height);
    }

    public static void main(String[] args) {
        SkylineProblem skylineProblem = new SkylineProblem();
        System.out.println(skylineProblem.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}
