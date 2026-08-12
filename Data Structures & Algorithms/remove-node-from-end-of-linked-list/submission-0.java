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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode (0,head) ;
        ListNode fst = dummy ;
        ListNode scnd = head ;
        while(n>0 && scnd!= null){
            scnd = scnd.next ;
            n -=1 ;
        }
        while(scnd != null ){
            fst = fst.next ;
            scnd = scnd.next ;


        }
            fst.next = fst.next.next ;
            return dummy.next ;
    }
}
