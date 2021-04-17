package 贪心.传递法.q121_1_买卖股票的最佳时机;

/**
 * 方法一：贪心
 * Java：97% 92%
 * 局部最优：每次都更新股票交易尽可能最大利润
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int res = 0;
        //(1)遍历所有股票价格
        for (int i = 1; i < n; i++) {
            //(2)贪心：动态保存最小股票价格，并不断尝试出售，保存最大利润的那次交易
            minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] > minPrice) {
                res = Math.max(prices[i] - minPrice, res);
            }
        }
        return res;
    }
}
