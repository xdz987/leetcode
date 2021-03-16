package 链表.q92_2_反转指定范围链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReReverseBetween itReverseBetween = new ReReverseBetween();
        head = itReverseBetween.reverseBetween(head, 1, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}

/**
 * 反转单链表范围m-n
 * 递归实现
 * 1. 当m=1时，即反转前N个节点
 * 2. 当m>1时，则head.next快进到base case。如m=2，n=4。那么head.next即为m=2-1，而n即数量则减1，相对上来看等同于反转前N个节点
 * 迭代实现
 */
class ReReverseBetween {
    //递归实现
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    //递归实现-执行函数
    ListNode successor = null; //后继节点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            //记录第n+1节点
            successor = head.next;
            return head;
        }
        // 以head.next为起点，需要反转前n-1个节点
        ListNode last = reverseN(head.next, n - 1);

        // 后一节点指向前一节点
        head.next.next = head;
        // 前一节点指向后继节点
        head.next = successor;

        // 返回新的head
        return last;
    }
}

/**
 * 反转单链表范围m-n
 * 迭代实现
 * 1. 定位截断反转法 O(2n)
 * 2. 定位头插法 O(n)
 */
class ItReverseBetween1 {

    //迭代实现1 截断反转法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 增加一个虚拟头节点，使得当left=1时即第一个节点也有前倾，从而不需要增加额外的逻辑判断
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //(1)定位到 不需要反转 的最后一个节点 (为了断开链接)。即需要反转的最左节点的前倾
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //(2)定位到 需要反转 范围的最后一个节点 (为了断开链接)
        ListNode rightNode = pre;
        for (int i = left; i <= right; i++) {
            rightNode = rightNode.next;
        }

        //(3)记录并截断反转链表的连接
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        //断开
        pre.next = null;
        rightNode.next = null;

        //(4)反转left到right的链表
        reverseList(leftNode);

        //(5)连接 完成反转的链表
        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;
    }

    //反转整个单链表链表
    public void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode succ = cur.next;
            //---上面完成初始化：pre前 cur中 next后---
            cur.next = pre;
            pre = cur;
            cur = succ;
        }
    }
}

/**
 * 定位头插法 O(n)
 * 定位到left，之和不断头插节点
 */
class ItReverseBetween2 {

    //迭代实现2  定位头插法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 增加一个虚拟头节点，使得当left=1时即第一个节点也有前倾，从而不需要增加额外的逻辑判断
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //(1)定位到需要反转的最左节点的前倾
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        //(2)开始反转。把需要反转的节点当做一个队列，从左到右重新将节点从左边放入队列，一轮循环后即反转
        for (int i = left + 1; i <= right; i++) {
            ListNode next = cur.next;

            //重新链接
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}