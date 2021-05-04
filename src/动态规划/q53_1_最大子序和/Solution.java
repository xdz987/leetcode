package 动态规划.q53_1_最大子序和;

/**
 * 方法一：DP
 * Java：100% 73%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //状态压缩
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}