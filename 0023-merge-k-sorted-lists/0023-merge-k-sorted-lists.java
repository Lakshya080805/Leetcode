/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Pair{
    int val;
    ListNode node;
    Pair(int val,ListNode node){
        this.val=val;
        this.node=node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode l:lists){
            if(l!=null){
                pq.offer(new Pair(l.val,l));
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;

        while(!pq.isEmpty()){
            Pair entry=pq.poll();
            ListNode curr=entry.node;

            tail.next=curr;
            tail=tail.next;

            if(curr.next!=null){
                pq.add(new Pair(curr.next.val,curr.next));
            }
        }

        return dummy.next;
    }
}