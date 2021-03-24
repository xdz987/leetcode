package 树.二叉搜索树.q701_2_BST插入操作;

import 树.二叉搜索树.TreeNode;

/**
 * BST二分查找
 * 二分查到root为null时，即为target的插入位置
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
