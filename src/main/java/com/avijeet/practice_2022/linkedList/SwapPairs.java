package com.avijeet.practice_2022.linkedList;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        while(curr!=null && curr.next!=null){
            ListNode next=curr.next;
            ListNode nextNext=next.next;
            if(curr==head){
                head=next;
            }
            next.next=curr;
            curr.next=nextNext;
            curr=nextNext;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head=null, prev=null;
        for(int ln:new int[]{1,2,3,4}){
            ListNode curr=new ListNode(ln);
            if(prev==null){
                head=curr;
            }else {
                prev.next=curr;
            }
            prev=curr;
        }
        System.out.println(swapPairs(head));;
    }
}
