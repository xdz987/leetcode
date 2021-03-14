package 链表.反转链表前n个节点;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverserN reverserN = new ReverserN();
        head = reverserN.reverseN(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 反转单链表前n个，返回新的head节点
 * 递归实现
 * 迭代实现
 */
class ReverserN {

    //递归实现
//    ListNode successor = null; //后继节点
//    public ListNode reverseN(ListNode head, int n) {
//        if (n == 1) {
//            //记录第n+1节点
//            successor = head.next;
//            return head;
//        }
//        // 以head.next为起点，需要反转前n-1个节点
//        ListNode last = reverseN(head.next, n - 1);
//
//        // 后一节点指向前一节点
//        head.next.next = head;
//        // 前一节点指向后继节点
//        head.next = successor;
//
//        // 返回新的head
//        return last;
//    }

    //迭代实现
    public ListNode reverseN(ListNode head, int n) {
        //(1)初始化前pre 中cur 后next指针。pre和cur进行节点交换，succ作记录作用记录后继节点
        ListNode pre = null;
        ListNode cur = head;
        int i = 1;

        //(2)循环交换指针 前与中交换
        while (i <= n) {
            //记录下一个指针
            ListNode succ = cur.next;

            //交换指针
            cur.next = pre;
            pre = cur;
            cur = succ;
            i++;
        }
        //(3)交换完成后，head则作为前n个节点的最后一个节点，连接n+1节点，完成反转
        head.next = cur;
        return pre;
    }
}