package 数组与矩阵.双指针.q142_2_环形链表2;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        HasCycle hasCycle = new HasCycle();
        System.out.println(hasCycle.detectCycle(head).val);
    }
}

/**
 * 141的延续
 * 快慢指针
 * 1. 找到环，此时因为相遇所以fast=slow
 * 2. 而此时，head到环的起点 = 相遇点到环的起点，所以可设slow=head
 * 3. fast和slow以相同速度向前走，当fast=slow时，则说明为起点
 */
class HasCycle {
    public ListNode detectCycle(ListNode head) {
        //(1)初始化快慢指针
        ListNode fast;
        ListNode slow;
        fast = slow = head;

        //(2)查找是否存在环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //无环
        if (fast == null || fast.next == null) {
            return null;
        }

        //(3)修改快慢指针，找到环的起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        //fast或slow都可
        return fast;
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