package 动态规划.q70_1_爬楼梯;

/**
 * 方法一：DP
 */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int weight = 3; weight <= n; weight++) {
            dp[weight] = dp[weight - 1] + dp[weight - 2];
        }
        return dp[n];
    }
}
