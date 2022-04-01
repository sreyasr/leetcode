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

// https://leetcode.com/problems/middle-of-the-linked-list/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode o = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        head = o;
        for(int i = 0; i < length/2; i++) {
            head = head.next;
        }
        return head;
    }
}
