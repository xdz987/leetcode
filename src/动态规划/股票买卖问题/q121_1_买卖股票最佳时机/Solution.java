package 动态规划.股票买卖问题.q121_1_买卖股票最佳时机;

/**
 * 方法一：暴力
 * Java：
 * 复杂度：O(N^2) O(1) 超时
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }
}
