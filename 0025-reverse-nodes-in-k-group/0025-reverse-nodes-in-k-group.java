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
class Solution {
    private static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static ListNode kthNode(ListNode temp,int k){
        
       k=k-1;
       while(temp!=null && k>0){
        k--;
        temp=temp.next;
       }
       return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode knode=kthNode(temp,k);
            if(knode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
           ListNode nextNode=knode.next;
           knode.next=null;
           reverse(temp);
           if(temp==head){
            head=knode;
           }
           else{
            prevNode.next=knode;
           }
           prevNode=temp;
           temp=nextNode;
        }
        return head;
    }
}