package 链表.q234_1_回文链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(head));
    }
}

/**
 * 快慢指针
 * 前一半链表反转，前一半比较后一半
 */
class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //(1)初始化快慢指针 反转指针
        ListNode fast = head;
        ListNode slow = head;
        ListNode current = head;
        ListNode pre = null;
        //(2)查中点并反转前半链表
        while (fast != null && fast.next != null) {
            current = slow;

            //查中点
            slow = slow.next;
            fast = fast.next.next;

            //反转前一半链表
            current.next = pre;
            pre = current;
        }
        //(3)修正slow
        //fast=null说明节点数为偶数
        //偶数时slow位于中间偏右一位，奇数位于正中间(正中间不进行判断)
        if (fast != null) {
            slow = slow.next;
        }

        //(4)比较两半是否为回文
        while (current != null) {
            if (current.val != slow.val) {
                return false;
            }
            current = current.next;
            slow = slow.next;
        }

        return true;
    }
}