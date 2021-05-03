package 动态规划.斐波那契类型.打家劫舍类.q337_2_打家劫舍3;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：记忆化递归
 * Java：54% 51%
 * 复杂度：O(N) O(2N) 空间为递归栈和记忆Map
 */
class Solution {

    Map<TreeNode, Integer> memories = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (memories.containsKey(root)) return memories.get(root);
        //偷父节点
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }

        //偷左右子节点
        int val2 = rob(root.left) + rob(root.right);
        memories.put(root, Math.max(val1, val2));
        return memories.get(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}