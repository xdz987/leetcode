package 动态规划.分割整数问题.q279_2_完全平方数;

/**
 * 方法一：DP
 * Java：80% 72%
 * 复杂度：O(N*sqrt(N)) O(1)
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //(1)遍历1~n
        for (int i = 1; i <= n; i++) {
            //dp[i]=i这里做了两件事
            // 1. 初始化最小子问题，dp[1]=1,dp[2]=3,dp[3]=3
            // 2. 初始化最坏情况，每个整数都由n个1组成
            dp[i] = i;
            //(2)动态保存最少数量
            for (int j = 2; j * j <= i; j++) {
                //状态选择：
                //选择目标：最少数量
                //选择列表：[小的完全平方数组成，大的完全平方数组成]
                //例如：12选择有[12-4+1=9，12-9+1=4，12-12+1=1]，当完全平方数j*j越大时越接近最优子问题
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}