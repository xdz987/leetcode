package 链表.q61_2_旋转链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RotateRight rotateRight = new RotateRight();
        head = rotateRight.rotateRight(head, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 方案一：设为环再断
 * 1. 计算节点数n并设为环
 * 2. 在第倒数k%n节点处断开(尾结点设为null)
 */
class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        //(1)备份头节点地址
        ListNode saveHead = head;

        //(2)计算节点数量
        int n = 1;
        while (head.next != null) {
            n++;
            head = head.next;
        }
        if (k % n == 0)
            return saveHead;

        //(3)设为环
        head.next = saveHead;
        head = saveHead;

        //(4)计算截断的位置，并重新连接
        int disconnect = k % n;
        while (disconnect < n - 1) {
            disconnect++;
            head = head.next;
        }
        saveHead = head.next;
        head.next = null;
        return saveHead;
    }
}