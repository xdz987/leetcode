package 动态规划.最长xx子序列.最长递增子序列.q300_2_最长递增子序列;

import java.util.Arrays;

/**
 * 方法一：DP
 * Java：
 * 复杂度：
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //(1)初始化dp数组，初始化边界即最小递增子序列为1
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        //(2)遍历所有[1,n)
        for (int i = 1; i < n; i++) {
            //(3)遍历[0~i-1)，即遍历i之前的所有递增子序列数/状态选择列表
            for (int j = 0; j < i; j++) {
                //(3.1)状态选择：取最大递增序列
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            //(4)动态保存截止至i的最大连续递增子序列
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}