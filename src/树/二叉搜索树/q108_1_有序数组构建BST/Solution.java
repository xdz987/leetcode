package 树.二叉搜索树.q108_1_有序数组构建BST;

import 树.二叉搜索树.TreeNode;

/**
 * 前序构建(类似快排)
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        //取mid为父节点
        int mid = low + ((high - low) >> 1);
        TreeNode root = new TreeNode(nums[mid]);

        //构建左右子树
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);
        return root;
    }
}
