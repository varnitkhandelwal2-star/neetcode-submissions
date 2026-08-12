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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (true) {
            if (!hasKNodes(curr, k)) break;

            ListNode groupStart = curr.next;
            ListNode groupEnd = getKthNode(curr, k);

            if (groupEnd == null) break;  // safety check

            ListNode nextGroup = groupEnd.next;

            groupEnd.next = null;
            ListNode newHead = reverse(groupStart);

            curr.next = newHead;
            groupStart.next = nextGroup;

            curr = groupStart;
        }

        return dummy.next;
    }

    private boolean hasKNodes(ListNode node, int k) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
            if (count == k) return true;
        }
        return false;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (k > 0 && node != null) {  // fixed: added null check
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}