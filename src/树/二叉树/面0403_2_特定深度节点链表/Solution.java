package 树.二叉树.面0403_2_特定深度节点链表;

import 树.二叉搜索树.ListNode;
import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历+链表
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        if (tree == null) return new ListNode[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //(1)窗口临时链表虚拟头节点
            ListNode tmpHead = new ListNode(-1);
            //备份
            ListNode backHead = tmpHead;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //(2)放入链表
                tmpHead.next = new ListNode(node.val);
                tmpHead = tmpHead.next;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            //(3)将链表加入list
            list.add(backHead.next);
        }

        //(4)List转数组
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
