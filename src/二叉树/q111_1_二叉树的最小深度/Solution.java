package 二叉树.q111_1_二叉树的最小深度;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 后序 深度优先
 * 同q104
 * 重点：
 * 1. 为叶节点或单边节点则提前返回
 * 2. 每个节点的深度中取最小
 */
class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //如果节点为叶子节点或者只有单边子树，则提前返回
        if (left == 0 || right == 0) {
            return left + right + 1;
        }

        //比较每一个节点的深度，保存最小深度。+1用于累计当前深度
        return Math.min(left, right) + 1;
    }
}