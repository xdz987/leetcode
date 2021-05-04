package 动态规划.股票买卖问题.q188_3_买卖股票的最佳时机4;

import java.util.Arrays;

/**
 * 方法一：DP
 * Java：86% 96%
 * 复杂度：O(2*K*N) O(2*K) 其中K为最大股票交易的次数
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dpSize = k * 2 + 1;
        //[0]是不交易，[奇数]是第(奇数/2)次持有股票，[偶数]是第(偶数/2)次出售股票
        int[] dp = new int[dpSize];
        //初始化每次持有股票时手上的现金
        for (int i = 1; i < dpSize; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 2; j < dpSize; j += 2) {
                //保存[持有(如果有交易)上次交易利润下购买今天股票，未持有上次交易利润下不购买今天股票]中手上持有金额的最大值情况。
                dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                //保存[今天卖出股票，今天不卖出股票]中手上持有金额的最大值情况
                dp[j - 1] = Math.max(dp[j - 1], dp[j - 2] - prices[i]);
            }
        }

        return dp[k * 2];
    }
}