package 动态规划.斐波那契类型.斐波那契数列.q650_2_只有两个键的键盘;

/**
 * 方法一：DP
 * Java：
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public int minSteps(int n) {
        //(1)初始化dp
        int[] dp = new int[n + 1];
        //(2)遍历[2,n)
        for (int i = 2; i <= n; i++) {
            //初始化dp边界
            dp[i] = i;
            //(2)遍历[2,i)
            for (int j = 2; j * j <= i; j++) {
                //当i%j==0时，更新dp[i]。说明素数为最差情况
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }
}