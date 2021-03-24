package 树.二叉搜索树.q700_1_BST搜索;

import 树.二叉搜索树.TreeNode;

/**
 * BST的二分查找
 * 比较当前节点与target的比较
 * 1. 等于直接返回
 * 2. 当前节点>target，在左子树，递归left
 * 3. 当前节点<target，在右子树，递归right
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
