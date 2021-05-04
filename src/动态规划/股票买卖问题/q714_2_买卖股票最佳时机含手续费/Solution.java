package 动态规划.股票买卖问题.q714_2_买卖股票最佳时机含手续费;

/**
 * 方法一：DP
 * Java：99% 92%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) return 0;
        int holdCash = -prices[0];
        int soldCash = 0;
        for (int i = 1; i < n; i++) {
            //q122，手续费可以放在售出股票时【减少收益】-fee或者放在买入股票时【增加股票价格】
            soldCash = Math.max(soldCash, holdCash + prices[i] - fee);
            holdCash = Math.max(holdCash, soldCash - prices[i]);
        }
        return soldCash;
    }
}