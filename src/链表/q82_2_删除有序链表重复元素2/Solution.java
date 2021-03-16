package 链表.q82_2_删除有序链表重复元素2;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 方法一：去重+标记法，遇到重复元素删除左边节点并标记，直到最后一个重复节点再删除
 * 方法二：递归
 * 递归 > 标记法
 */
class DeleteDuplicates {
    // 去重+标记法
//    public ListNode deleteDuplicates(ListNode head) {
//        //(1)初始化虚拟头结点、前节点pre
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        ListNode pre = dummyNode;
//
//        //(2)删除重复元素
//        while (head != null && head.next != null) {
//            boolean repeat = false;
//            //(2.1)删除所有重复除最后一个外的节点
//            if (head.val == head.next.val) {
//                repeat = true;
//
//                //删除左边重复节点
//                pre.next = head.next;
//            } else {
//                pre = head;
//            }
//            head = head.next;
//
//            //(2.2)删除剩余最后一个重复节点
//            if ((repeat && head.next == null) || (repeat && head.val != head.next.val)) {
//                pre.next = head.next;
//                head = head.next;
//            }
//        }
//        return dummyNode.next;
//    }

    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            //(1)跳过重复的节点，除最后一个重复节点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }

            //(2)子递归出口，跳过最后一个重复节点
            return deleteDuplicates(head.next);
        } else {
            //(3)递归下一个节点判定是否为重复节点，返回不重复节点
            head.next = deleteDuplicates(head.next);

            //函数出口
            return head;
        }
    }
}