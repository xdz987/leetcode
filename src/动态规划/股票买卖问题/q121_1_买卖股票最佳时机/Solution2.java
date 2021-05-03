package 动态规划.股票买卖问题.q121_1_买卖股票最佳时机;

/**
 * 方法二：暴力优化/贪心
 * Java：60% 80%
 * 复杂度：O(N) O(1)
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i - 1]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
