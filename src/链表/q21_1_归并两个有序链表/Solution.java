package 链表.q21_1_归并两个有序链表;

import 链表.ListNode;

import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 递归实现：不断递归比较，传入小的节点并往回保存
 * 迭代实现：
 * 1.创建一个新node作保存
 * 2.循环遍历l1和l2，新node保存更小的那个，直到l1或l2为null
 * 3.将另一个不为null(剩下的都是大数)的连接到新node
 * 迭代 > 递归
 */
class MergeTwoLists {
    //递归实现
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l2.next, l1);
            return l2;
        }
    }

    //迭代实现
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = (l1 == null) ? l2 : l1;

        return dummyNode.next;
    }
}