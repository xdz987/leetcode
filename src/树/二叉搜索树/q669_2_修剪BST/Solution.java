package 树.二叉搜索树.q669_2_修剪BST;

import 树.二叉搜索树.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题意：不是要求clone，而是要求不改变val值，只能改指针即left,right
 * 方法一：层序遍历找出[low,high]范围的节点，并逐节点插入新的BST树 （clone树，忽略)
 * 方法二：前序遍历，原地剪枝
 */
class Solution {

    //方法一：层序遍历(栈)
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode newBST = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val >= low && node.val <= high) {
                newBST = insertBST(newBST, node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return newBST;
    }

    private TreeNode insertBST(TreeNode newBST, int val) {
        if (newBST == null) {
            return new TreeNode(val);
        }
        if (newBST.val > val) {
            newBST.left = insertBST(newBST.left, val);
        } else {
            newBST.right = insertBST(newBST.right, val);
        }
        return newBST;
    }
}

class Solution2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}