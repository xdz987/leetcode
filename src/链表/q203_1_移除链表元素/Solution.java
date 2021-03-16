package 链表.q203_1_移除链表元素;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(6);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(6);
        RemoveElements removeElements = new RemoveElements();
        head = removeElements.removeElements(head, 6);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 设立pre指针，相等则跳过
 */
class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode saveHead = pre;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }else{
                pre = head;
            }
            head = head.next;
        }

        return saveHead.next;
    }
}