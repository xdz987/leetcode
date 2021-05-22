package 树.二叉树.剑68_2面0408q236_2_二叉树最近公共祖先;

import 树.二叉树.TreeNode;

/**
 * 方法二：后序，通过boolean值
 */
public class Solution2 {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        find(root, p, q);
        return res;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);

        boolean cur = root.val == p.val || root.val == q.val;

        if (left && right) {
            res = root;
            return false;
        }
        if ((left || right) && cur) {
            res = root;
            return false;
        }
        return left || right || cur;
    }
}
