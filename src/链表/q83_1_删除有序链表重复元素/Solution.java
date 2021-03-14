package 链表.q83_1_删除有序链表重复元素;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        head = deleteDuplicates.deleteDuplicates(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode saveHead = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return saveHead;
    }
}