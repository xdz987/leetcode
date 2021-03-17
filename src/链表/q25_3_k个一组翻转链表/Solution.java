package 链表.q25_3_k个一组翻转链表;

import 链表.ListNode;

import java.awt.*;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        head = reverseKGroup.reverseKGroup(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * q92多次版
 * 截断-翻转-链接
 * 重点：将截断的最后一个节点作为遍历的变量，使得循环与截断逻辑不分离
 */
class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //需翻转节点段的前一节点
        ListNode pre = dummyNode;
        //需翻转的最后一个节点
        ListNode end = dummyNode;

        while (end != null) {
            //(1)如果未k个一组则翻转
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            //(2)开始反转
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            //保存结果
            pre.next = reverseList(start);

            //(3)链接完成，进行链接。
            //反转后的尾结点指向下一待反转节点
            start.next = next;

            //(4)准备下次翻转
            //需要反转节点段的前一节点
            pre = start;
            //while循环指向开头
            end = start;
        }
        return dummyNode.next;
    }

    //翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;

            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
