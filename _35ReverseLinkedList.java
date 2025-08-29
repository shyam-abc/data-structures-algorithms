package com.datastructures_algorithms.neetcode_150._2_25;
/**
https://leetcode.com/problems/reverse-linked-list/
 */
public class _35ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
