package 链表.剑18_1_删除链表的节点;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 1. 设置虚拟头节点保存head地址，同时设其为pre节点
 * 2. 遍历链表，相等则使得pre跳过下一个节点
 * 3. 通过虚拟头节点返回真实头节点地址
 */
class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        while (head != null) {
            if (head.val == val) {
                pre.next = pre.next.next;
                break;
            }
            pre = head;
            head = head.next;
        }

        return dummyNode.next;
    }
}
