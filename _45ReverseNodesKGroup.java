package com.datastructures_algorithms.neetcode_150._2_25;

/**
https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class _45ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;

        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        ListNode prev = null, curr = head, next = null;
        int i = 0;

        while (i < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
