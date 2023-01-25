package com.avijeet.practice_2022.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString(){
        return val+" --> "+next;
    }
}

public class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode ln : lists) {
            if(ln!=null)
                pq.add(ln);
        }

        ListNode head=null, prev=null;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            if (prev == null) {
                head = curr;
            }else {
                prev.next=curr;
            }
            prev=curr;
            ListNode next = curr.next;
            if (next != null)
                pq.add(next);
            curr.next=null;
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] slarr=new int[][]{{1,4,5},{1,3,4},{2,6}};
        ListNode[] sortedList=new ListNode[slarr.length];
        int i=0;
        for(int[] lns:slarr){
            ListNode head=null, prev=null;
            for(int ln:lns){
                ListNode curr=new ListNode(ln);
                if(prev==null){
                    head=curr;
                }else {
                    prev.next=curr;
                }
                prev=curr;
            }
            sortedList[i]=head;
            System.out.println(head);
            i++;
        }
        System.out.println(mergeKLists(sortedList));
    }
}
