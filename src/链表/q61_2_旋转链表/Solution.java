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
        if (head == null || head.next == null)
            return head;

        //(1)设虚拟头结点保存原头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int n = 1;

        //(2)计算节点数量，并设为环
        while (head != null) {
            n++;
            head = head.next;
            if (head.next == null) {
                //说明移完原封不动
                if (k % n == 0) {
                    return dummyNode.next;
                }
                //设为环
                head.next = dummyNode.next;
                break;
            }
        }
        head = dummyNode.next;

        //(3)根据n与k的值，断开环并设尾结点为null
        // 倒数第k-1处断开
        int disconnect = k % n;
        while (disconnect < n) {
            disconnect++;
            //保存头部，并断开尾部
            if (disconnect == n) {
                dummyNode.next = head.next;
                head.next = null;
            } else {
                head = head.next;
            }
        }

        return dummyNode.next;
    }
}