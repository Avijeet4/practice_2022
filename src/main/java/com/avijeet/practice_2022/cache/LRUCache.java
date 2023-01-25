package com.avijeet.practice_2022.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map=new HashMap<>();
    Node head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node=map.get(key);
            node.val=value;
            remove(node);

        }else{
            if(map.size() == capacity){
                map.remove(removeFromLast().key);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        add(node);

    }

    private void add(Node node){
        if(head==null){
            head=node;
            tail=node;
        }else{
            head.prev=node;
            node.next=head;
            head=node;
            node.prev=null;
        }
    }
    private void remove(Node node){
        if(node.prev!=null)
            node.prev.next=node.next;
        if(node.next!=null)
            node.next.prev=node.prev;
        else
            tail=node.prev;
        node.next=node.prev=null;
    }
    private Node removeFromLast(){
        Node node=tail;
        if(tail.prev==null){
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
            tail.next.prev=null;
            tail.next=null;
        }
        return node;
    }

    public static void main(String[] args) {
        input(
                new String[]{"LRUCache","put","put","get","put","get","put","get","get","get"},
                new int[][] {{2},{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4}}
        );
    }

    private static void input(String[] ops,int[][] opVal){
        LRUCache lruCache=null;
        int n=ops.length;
        for(int i=0;i<n;i++){
            if(ops[i].equals("LRUCache")){
                int capacity=opVal[i][0];
                lruCache=new LRUCache(capacity);
            }else if(ops[i].equals("put")){
                int key=opVal[i][0];
                int val=opVal[i][1];
                lruCache.put(key, val);
            }else if(ops[i].equals("get")){
                int key=opVal[i][0];
                System.out.println(lruCache.get(key));
            }
        }
    }
}
class Node{
    int key, val;
    Node prev, next;
    Node(int _key, int _val){
        key=_key;
        val=_val;
    }
}