package 其他算法.双指针.q141_1_环形链表;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        HasCycle hasCycle = new HasCycle();
        System.out.println(hasCycle.hasCycle(head));
    }
}

/**
 * 快慢指针
 * 循环链表，fast的速度设为slow的两倍，当fast与slow相遇时则处于环
 */
class HasCycle {
    public boolean hasCycle(ListNode head) {
        //(1)初始化快慢指针
        ListNode fast;
        ListNode slow;
        fast = slow = head;

        //(2)查找是否存在环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
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