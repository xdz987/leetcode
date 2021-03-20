package 二叉树.q654_2_最大二叉树;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 前序构建法
 */
class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }

        //(1)找到最大数
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        //(2)构建父节点
        TreeNode root = new TreeNode(max);

        //(3)递归构建左右子节点，范围不包括父节点(max值)下标
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);

        return root;
    }
}