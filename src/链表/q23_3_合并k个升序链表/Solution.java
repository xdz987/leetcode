package 链表.q23_3_合并k个升序链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 归并-合并两个链表
 */
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    //归并-合并
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    //q21 合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                res.next = l2;
                l2 = l2.next;
            } else {
                res.next = l1;
                l1 = l1.next;
            }
            res = res.next;
        }
        res.next = (l1 == null) ? l2 : l1;
        return dummyNode.next;
    }
}