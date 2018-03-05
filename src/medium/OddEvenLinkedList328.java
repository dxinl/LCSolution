package medium;

import datastructure.ListNode;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode preEven = null;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;
            if (preEven == null) {
                odd.next.next = even;
            } else {
                preEven.next = even;
                odd.next.next = preEven;
            }
            preEven = even;
            odd = odd.next;
            even = even.next;
        }
        return head;
    }
}
