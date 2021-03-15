package 链表.剑06_1_从尾到头打印链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 先算节点数，再初始化数组，倒着放进数组即可
 */
class ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        head = dummyNode.next;

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }

        return res;
    }
}