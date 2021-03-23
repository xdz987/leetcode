package 二叉树.剑68_2q236_2_二叉树最近公共祖先;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 重点：
 * 1. 如果left和right同时为null。则不存在
 * 2. 如果left或right任一为null，而另一不为null。则说明来自同一子树，以高的为父节点
 * 3. 如果left或right均不为null，则说明来自同一子树。则以高的值的父节点为最近祖先
 */
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //(1)root为null或者，p与q任一等于root节点，直接返回root
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //(2)针对各种情况
        // 情况1
        if (left == null && right == null) {
            return null;
        }
        // 情况2
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        // 情况3
        return root;
    }
}