package 动态规划.股票买卖问题.q309_2_最佳买卖时机含冷冻期;

/**
 * 方法一：DP
 * Java：99% 94%
 * 复杂度：O(N) O(1)
 */
class Solution {
    //思路一：增加冷冻期。【四个状态】(淘汰)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[4][n];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[3][i - 1]) - prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[3][i - 1]);
            dp[2][i] = dp[0][i - 1] + prices[i];
            dp[3][i] = dp[2][i - 1];
        }
        return Math.max(dp[1][n - 1], Math.max(dp[2][n - 1], dp[3][n - 1]));
    }

    //思路二：增加1天的冷冻期，就意味着今天买入股票时的现金是基于前前天的交易收益情况。【两个状态】
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        //(1)初始化dp
        //dp[0]持有股票时手上的现金
        //dp[1]售出股票时手上的现金
        int[][] dp = new int[2][n];
        dp[0][0] = -prices[0];
        //(2)遍历每天的股票价格
        for (int i = 1; i < n; i++) {
            //基于【前前天】卖出股票收益下持有股票
            dp[0][i] = Math.max(dp[0][i - 1], (i == 1 ? 0 : dp[1][i - 2]) - prices[i]);
            //根据持有股票手上现金与当天股票价格，取得卖出股票的最大收益
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
        }
        return dp[1][n - 1];
    }


    //思路二：状态压缩
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int holdCash = -prices[0];
        int lastSoldCash = 0;
        int soldCash = 0;
        for (int i = 1; i < n; i++) {
            int tmp = soldCash;
            soldCash = Math.max(soldCash, holdCash + prices[i]);
            holdCash = Math.max(holdCash, lastSoldCash - prices[i]);
            lastSoldCash = tmp;
        }
        return soldCash;
    }
}