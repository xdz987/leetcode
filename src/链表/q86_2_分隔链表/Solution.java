package 链表.q86_2_分隔链表;

import 链表.ListNode;

import java.rmi.dgc.Lease;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        Partition partition = new Partition();
        head = partition.partition(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 拆分合并：
 * 将小x的节点存入新链表，大于等于x的从链表中删除，最后连接两个链表
 */
class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        //(1)初始化
        //小于x的头节点leftHead，并保存头结点于newLeftHead
        ListNode leftHead = new ListNode(Integer.MIN_VALUE);
        ListNode newLeftHead = leftHead;
        //大于x的头结点rightPre，并保存头结点于newRightHead
        ListNode rightPre = new ListNode(Integer.MIN_VALUE);
        ListNode newRightHead = rightPre;
        rightPre.next = head;

        //(2)将小于x的节点从原链表中删除，并接入leftHead
        while (head != null) {
            if (head.val < x) {
                //删除小于x的节点，head指向下一节点
                rightPre.next = head.next;

                //连接小的节点
                leftHead.next = head;
                leftHead = head;
            } else {
                //更新大于x的前一节点
                rightPre = head;
            }
            head = head.next;
        }

        //(3)将小于x的尾结点连接大于x的头结点
        leftHead.next = newRightHead.next;

        //返回小于x的头结点
        return newLeftHead.next;
    }
}