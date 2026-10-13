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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy ; 
        
        int i=0 ;
        while(i<left-1) {
            curr = curr.next ;
            i++ ;
        }
        ListNode beforeleft = curr ;
        ListNode tail = curr.next ;
        ListNode prev = null ;
        curr = curr.next ;

        for(int j=0 ; j<right-left+1 ; j++) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

        }

    beforeleft.next = prev;
    tail.next = curr;
    
    return dummy.next ;
    }
}