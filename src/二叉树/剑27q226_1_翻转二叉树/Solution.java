package 二叉树.剑27q226_1_翻转二叉树;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 二叉树前序遍历
 */
class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 交换左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}