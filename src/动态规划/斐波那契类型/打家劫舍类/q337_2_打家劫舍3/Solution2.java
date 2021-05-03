package 动态规划.斐波那契类型.打家劫舍类.q337_2_打家劫舍3;

/**
 * 方法一：树型DP
 * Java：80% 95%
 * 复杂度：O(N) O(N)
 */
public class Solution2 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robTree(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        //偷的结果
        int selected = root.val + left[0] + right[0];

        //不偷的结果
        int noSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{noSelected, selected};
    }
}
