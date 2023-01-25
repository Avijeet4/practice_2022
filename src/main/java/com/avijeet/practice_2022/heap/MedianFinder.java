package com.avijeet.practice_2022.heap;

import java.util.Optional;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>((n1, n2) -> Integer.compare(n2, n1));
    PriorityQueue<Integer> maxHeap=new PriorityQueue();
    public MedianFinder() {

    }

    public void addNum(int num) {
        // s.add(-1*num);
        if(minHeap.isEmpty()||minHeap.peek()>=num){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }
        if(maxHeap.size()>minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size()-1>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }
        return ((double)minHeap.peek()+(double)maxHeap.peek())/2;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder= new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
