package 链表.剑53q160_1_找出两链表的交点;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 双指针
 * a+b+c=b+a+c，所以a指针与b指针同时走会出现以下情况：
 * (1)a=b，当a与b走到c时直接l1==l2，无需走c的节点
 * (2)a>b或b>a，当a->c->b时，b也是b->c->a，此时l1和l2会在c点即交点相遇
 */
class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}