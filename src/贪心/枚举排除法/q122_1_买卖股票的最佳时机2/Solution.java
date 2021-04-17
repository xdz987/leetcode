package 贪心.枚举排除法.q122_1_买卖股票的最佳时机2;

/**
 * 方法一：贪心
 * 局部最优：收集每天的正利润
 * Java：100% 45%
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1])
                sum += prices[i] - prices[i - 1];
        }
        return sum;
    }
}
