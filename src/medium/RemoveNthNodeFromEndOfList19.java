package medium;

import datastructure.ListNode;

public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode fast = head;
        while (count < n) {
            fast = fast.next;
            count++;
        }

        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (fast == null) {
            return slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
