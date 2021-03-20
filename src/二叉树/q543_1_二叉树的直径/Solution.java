package 二叉树.q543_1_二叉树的直径;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 题意：找最大深度节点与第二大深度节点之和
 */
class DiameterOfBinaryTree {
    int res = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return res;
    }


    private int find(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = find(root.left);
        int right = find(root.right);

        //保存两个深度之和中最大值，即为最长直径
        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}
