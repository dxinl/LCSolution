package medium;

import datastructure.ListNode;

public class SortList148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode tmp = head.next = new ListNode(5);
        tmp = tmp.next = new ListNode(1);
        tmp = tmp.next = new ListNode(2);
        tmp = tmp.next = new ListNode(6);
        tmp = tmp.next = new ListNode(4);

        SortList148 sort = new SortList148();
        ListNode node = sort.sortList(head);
        System.out.println(node);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        int interval = 1;
        ListNode h1 = head, h2 = getNextH(head, interval), h3 = getNextH(h2, interval);
        ListNode pre = null;
        while (h2 != null) {
            while (h1 != null && h2 != null) {
                if (pre == null) {
                    head = h1.val > h2.val ? h2 : h1;
                }
                pre = mergeSort(pre, h1, h2, h3, interval);
                h1 = h3;
                h2 = getNextH(h1, interval);
                h3 = getNextH(h2, interval);
            }
            interval <<= 1;
            h1 = head;
            h2 = getNextH(head, interval);
            h3 = getNextH(h2, interval);
            pre = null;
        }
        return head;
    }

    private ListNode getNextH(ListNode head, int interval) {
        if (head == null) {
            return null;
        }

        ListNode h2 = head;
        for (int i = 0; i < interval; i++) {
            if (h2.next == null) {
                return null;
            }
            h2 = h2.next;
        }

        return h2;
    }

    private ListNode mergeSort(ListNode pre, ListNode h1, ListNode h2, ListNode h3, int size) {
        if (h2 == null) {
            return null;
        }
        int i = 0, j = 0;
        while (i < size && j < size && h2 != null) {
            if (pre == null) {
                if (h1.val > h2.val) {
                    pre = h2;
                    h2 = h2.next;
                    j++;
                } else {
                    pre = h1;
                    h1 = h1.next;
                    i++;
                }
            } else {
                if (h1.val > h2.val) {
                    pre.next = h2;
                    pre = h2;
                    h2 = h2.next;
                    j++;
                } else {
                    pre.next = h1;
                    pre = h1;
                    h1 = h1.next;
                    i++;
                }
            }
        }

        if (i < size) {
            if (pre == null) {
                pre = h1;
            } else {
                pre.next = h1;
                pre = h1;
            }
            i++;
            while (i < size) {
                pre = pre.next;
                i++;
            }
            pre.next = null;
        } else if (j < size && h2 != null) {
            if (pre == null) {
                pre = h2;
            } else {
                pre.next = h2;
                pre = h2;
            }
            j++;
            while (j < size) {
                if (pre.next != null) {
                    pre = pre.next;
                    j++;
                } else {
                    break;
                }
            }
        }

        pre.next = h3;
        return pre;
    }
}
