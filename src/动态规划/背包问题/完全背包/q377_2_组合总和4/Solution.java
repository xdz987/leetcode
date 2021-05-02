package 动态规划.背包问题.完全背包.q377_2_组合总和4;

/**
 * 方法一：DP——完全背包排列问题
 * Java：96% 76%
 * 复杂度：O(N*M) O(M+1) 其中M为目标整数
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        //(1)初始化dp，当目标数字为0时存在1种排列方式(即不选)
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //(2)排列，外循环为"背包重量"
        for (int weight = 1; weight <= target; weight++) {
            //(3)排列，内循环为"商品"
            for (int goods = 0; goods < n; goods++) {
                //(4)当背包放的下商品时，保存排列数
                if (weight >= nums[goods])
                    dp[weight] += dp[weight - nums[goods]];
            }
        }
        return dp[target];
    }
}