package 链表.q2_2_两数相加;

import 链表.ListNode;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 同q445，只是l1、l2和结果都是头尾相反(更方便，不用转栈)
 */
class ddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode cnt = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            cnt.next = node;
            cnt = cnt.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyNode.next;
    }
}