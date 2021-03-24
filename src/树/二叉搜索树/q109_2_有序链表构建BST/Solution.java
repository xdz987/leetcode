package 树.二叉搜索树.q109_2_有序链表构建BST;

import 树.二叉搜索树.TreeNode;
import 树.二叉搜索树.ListNode;


/**
 * 方法一：链表转数组，再二分构建BST。略
 * 方法一：快慢指针+二分法
 * 方法三：BST中序遍历特性+二分法
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    //构建BST
    public TreeNode build(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode mid = getMid(start, end);
        TreeNode root = new TreeNode(mid.val);

        //左闭右开[)
        root.left = build(start, mid);
        root.right = build(mid.next, end);

        return root;
    }

    //快慢指针查链表中点
    private ListNode getMid(ListNode start, ListNode end) {
        //(1)找到中点
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

//方法二
class Solution2 {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //备份head
        globalHead = head;
        //由于不是数组下标，所以0或1开始都行
        int length = getLength(head);
        return build(1, length);
    }

    //构建BST
    private TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        //(1)查mid
        int mid = start + ((end - start) >> 1);
        //(2)先构建节点不赋值
        TreeNode root = new TreeNode();
        //(3)中序遍历赋值
        root.left = build(start, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = build(mid + 1, end);

        return root;
    }

    //查找链表长度
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}