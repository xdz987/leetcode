package 链表.q725_2_分隔链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 计算节点数量，计算分割节点数量，填充
 */
class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        //(1)计算节点数量n
        int n = 0;
        ListNode cnt = root;
        while (cnt != null) {
            n++;
            cnt = cnt.next;
        }
        cnt = root;

        //(2)计算每个分割链表的数量
        int size = n / k;
        int mod = n % k;


        ListNode[] res = new ListNode[k];
        //(3)填充每段链表节点
        for (int i = 0, j = 0; i < n && j < k; i++) {
            int sum = size + (mod-- > 0 ? 1 : 0);
            res[j++] = cnt;
            for (int s = 0; s < sum - 1; s++) {
                cnt = cnt.next;
            }

            //备份节点
            ListNode next = cnt.next;

            cnt.next = null;
            cnt = next;
        }

        return res;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode backHead = root;
        int size = 0;
        while (backHead != null) {
            size++;
            backHead = backHead.next;
        }
        int average = size / k;
        int surplus = size % k;
        ListNode[] res = new ListNode[k];
        int resI = 0;

        ListNode splitHead = root;
        int splitCount = average + (surplus > 0 ? 1 : 0);
        surplus--;
        res[resI++] = splitHead;
        while (root != null && root.next != null) {
            splitCount--;
            if (splitCount == 0) {
                ListNode tmp = root.next;
                root.next = null;
                root = tmp;
                splitHead = root;
                splitCount = average + (surplus > 0 ? 1 : 0);
                surplus--;
                res[resI++] = splitHead;
            } else {
                root = root.next;
            }
        }
        return res;
    }
}