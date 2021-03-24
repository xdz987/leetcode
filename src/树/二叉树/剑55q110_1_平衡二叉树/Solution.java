package 树.二叉树.剑55q110_1_平衡二叉树;

import 树.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 比较左右子树的深度，如相差大于1则false
 */
class IsBalanced {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        balance(root);
        return res;
    }

    private int balance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = balance(root.left);
        int right = balance(root.right);

        //比较左右深度是否大于1，当任一子树到达叶节点，而另一子树非叶继续递归时，前者的深度值保持不变，而后者则继续加大，最终超过1
        if (Math.abs(left - right) > 1) {
            res = false;
        }

        return Math.max(left, right) + 1;
    }
}