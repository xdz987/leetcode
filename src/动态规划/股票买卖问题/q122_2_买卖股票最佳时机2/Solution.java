package 动态规划.股票买卖问题.q122_2_买卖股票最佳时机2;

/**
 * 方法一：DP
 * Java：36% 92%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[0]持有股票时手上的现金
        //dp[1]售出股票时手上的现金
        int[][] dp = new int[2][n];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //与一次买卖的区别：多次交易，所以需要将先前交易的利润也代入计算
            //状态选择1：是否选择今天持有，当使得持有金额最大时（即股票价格最小）。【不同点】需将前面交易所得利润也带入为持有现金，否则意味着先前的交易为无效，为单次交易
            dp[0][i] = Math.max(dp[0][i - 1], -prices[i] + dp[1][i - 1]);
            //状态选择2：是否选择今天卖出，当获得最大价值时
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
        }
        return dp[1][n - 1];
    }

    //状态压缩
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int holdCash = -prices[0];
        int soldCash = 0;
        for (int i = 1; i < n; i++) {
            soldCash = Math.max(soldCash, prices[i] + holdCash);
            holdCash = Math.max(holdCash, -prices[i] + soldCash);
        }
        return soldCash;
    }

    //状态压缩——滚动数组，略
}