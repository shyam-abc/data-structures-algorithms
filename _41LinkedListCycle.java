package com.datastructures_algorithms.neetcode_150._2_25;

/**
https://leetcode.com/problems/linked-list-cycle/description/?envType=problem-list-v2&envId=hash-table
 */
public class _41LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
