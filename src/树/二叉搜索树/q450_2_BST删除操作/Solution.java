package 树.二叉搜索树.q450_2_BST删除操作;

import 树.二叉搜索树.TreeNode;

/**
 *
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 情况1、2
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 情况3
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root, min.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
