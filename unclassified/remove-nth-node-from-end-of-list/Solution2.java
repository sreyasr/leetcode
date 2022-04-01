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
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode h = head;
        while(h != null) {
            h = h.next;
            size++;
        }
        if(size == 1) {
            return null;
        }
        if(n == size) {
            return head.next;
        }
        h = head;
        for(int i = 0; i < size - n - 1; i++) {
            h = h.next;
        }
        h.next = h.next.next;
        return head;
    }
}