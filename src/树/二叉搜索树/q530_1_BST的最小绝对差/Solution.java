package 树.二叉搜索树.q530_1_BST的最小绝对差;

import 树.二叉搜索树.TreeNode;

/**
 * 中序遍历，不断保存前后值相减的最小值
 */
public class Solution {
    int res = Integer.MAX_VALUE;
    int last = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        find(root);
        return res;
    }

    private void find(TreeNode root) {
        if (root == null) {
            return;
        }

        find(root.left);
        //前后相减保存最小值
        int deffer = Math.abs(root.val - last);
        last = root.val;
        res = Math.min(res, deffer);
        find(root.right);
    }
}
