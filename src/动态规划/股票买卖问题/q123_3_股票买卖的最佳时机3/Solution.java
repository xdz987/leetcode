package 动态规划.股票买卖问题.q123_3_股票买卖的最佳时机3;

/**
 * 方法一：DP
 * Java：86% 83%
 * 复杂度：O(N) O(N*5)/O(1)状态压缩
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[5][n];
        //不交易时手上持有现金
        dp[0][0] = 0;
        //第一次购入股票时手上持有现金
        dp[1][0] = -prices[0];
        //第一次出售股票时手上持有现金。必定>=0
        dp[2][0] = 0;
        //第二次购入股票时手上持有现金
        dp[3][0] = -prices[0];
        //第二次出售股票时手上持有现金。必定>=0
        dp[4][0] = 0;
        for (int i = 1; i < n; i++) {
            //保持不购买股票。不交易始终为0，可用0替代
            dp[0][i] = dp[0][i - 1];
            //始终保存[购买今天股票，不购买今天股票]中手上持有金额的最大值情况/最小股票价格。
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
            //始终保存[今天卖出股票，今天不卖出股票]中手上持有金额的一次交易最大值情况。如果没有卖出后大于0的情况，那么始终为0。
            dp[2][i] = Math.max(dp[2][i - 1], dp[1][i - 1] + prices[i]);
            //保存[持有(如果有交易)上次交易利润下购买今天股票，未持有上次交易利润下不购买今天股票]中手上持有金额的最大值情况。
            //不存在卖出后立马买入的情况。比如第一次买入为1，今天股票=5，得到利润=4。第二次买入Max(0,4-5)=0，所以必定不会卖出又立马买入
            //dp[2][i-1]为上一次最大最大交易
            dp[3][i] = Math.max(dp[3][i - 1], dp[2][i - 1] - prices[i]);
            //保存[今天卖出股票，今天不卖出股票]中手上持有金额的最大值情况
            dp[4][i] = Math.max(dp[4][i - 1], dp[3][i - 1] + prices[i]);
        }
        return dp[4][n - 1];
    }


    //状态压缩
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        //始终保存最小的股票价格
        int firstHoldCash = -prices[0];
        //始终保存最大交易收益
        int firstSoldCash = 0;
        //基于第一次交易收益再找最小的股票价格
        int secondHoldCash = -prices[0];
        //基于第一次交易收益保存最大交易收益（即两次）
        int secondSoldCash = 0;
        for (int i = 1; i < n; i++) {
            firstSoldCash = Math.max(firstSoldCash, prices[i] + firstHoldCash);
            firstHoldCash = Math.max(firstHoldCash, -prices[i]);
            secondSoldCash = Math.max(secondSoldCash, secondHoldCash + prices[i]);
            secondHoldCash = Math.max(secondHoldCash, -prices[i] + firstSoldCash);
        }
        return secondHoldCash;
    }
}