package 树.二叉树.q404_1_左叶子之和;

import 树.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 前序
 * 重点：
 * 1. 判断叶子节点是left和right都为null
 * 2. 判断是左子树则需要父节点才能判断，所以可作为参赛代入递归
 */
class SumOfLeftLeaves {
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        cal(root, false);
        return res;
    }

    private void cal(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }

        //如果是左叶子节点，则累加值
        if (isLeft && root.left == null && root.right == null) {
            res += root.val;
        }

        cal(root.left, true);
        cal(root.right, false);
    }
}