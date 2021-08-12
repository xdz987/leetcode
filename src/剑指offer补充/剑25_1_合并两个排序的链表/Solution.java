package 剑指offer补充.剑25_1_合并两个排序的链表;

import 链表.ListNode;

/**
 * 方法一：递归
 * Java：100% 44%
 * 复杂度：O(N+M) O(N+M)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null)
            cur.next = l1;
        if(l2!=null)
            cur.next = l2;
        return dummy.next;
    }
}