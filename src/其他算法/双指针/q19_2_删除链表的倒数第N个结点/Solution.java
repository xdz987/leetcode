package 其他算法.双指针.q19_2_删除链表的倒数第N个结点;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 快慢指针
 * 先让快指针走n步，再快慢指针同时走，当快指针达到终点时，慢指针即指向倒数第n个结点
 */
class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //(1)定义快慢指针
        ListNode fast;
        ListNode slow;
        fast = slow = head;

        //(2)快指针先走n步
        for (int i = n; i > 0; i--) {
            fast = fast.next;
        }

        //说明倒数第n结点为第一个结点
        if (fast == null) {
            return head.next;
        }

        //(3)快慢指针同时走，到终点则查到倒数第n结点
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}