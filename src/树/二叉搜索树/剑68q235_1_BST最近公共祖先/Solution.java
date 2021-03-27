package 树.二叉搜索树.剑68q235_1_BST最近公共祖先;

import 树.二叉搜索树.TreeNode;

/**
 * 由于是BST，所以直接通过root.val比较p,q得出以下情况：
 * 1. 如集中在左/右子树则向左/右递归
 * 2. 在左右子树或root，直接返回当前root
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 位于左子树
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 位于右子树
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}