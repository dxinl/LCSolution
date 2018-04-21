package hard;

import datastructure.ListNode;

public class MergeKSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) {
            return null;
        }

        while (size > 1) {
            for (int i = 0; i < size; i++) {
                int first = (i << 1);
                int second = first + 1;
                if (first < size && second < size) {
                    ListNode l1 = lists[first];
                    ListNode l2 = lists[second];
                    lists[i] = mergeTwoSortedLists(l1, l2);
                } else {
                    if (first < size) {
                        lists[i] = lists[first];
                        size = i + 1;
                    } else {
                        size = i;
                    }
                    break;
                }
            }
        }

        return lists[0];
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        // 通过递归拼接链表
        // 两个链表的当前节点小的要不就是合并后的头结点，
        // 要不就已经拼接到之前的节点中，所以只需将小节点的next与大节点对比
        // 就可以得到当前小节点的下一个节点，以此类推就可以合并两条链表。
        // 因此使用递归就可以解决这个问题。
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }
    }
}
