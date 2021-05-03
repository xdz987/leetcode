package 动态规划.股票买卖问题.q121_1_买卖股票最佳时机;

/**
 * 方法三：DP
 * Java：
 * 复杂度：O(N) O(1)
 */
public class Solution3 {

    //动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[0]持有股票时手上的现金
        //dp[1]售出股票时手上的现金（最后的现金肯定是卖出所有股票最大啦）
        int[][] dp = new int[2][n];
        dp[0][0] = -prices[0];
        //第一次卖出，但无法同一天卖出，所以为0
        //dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            //状态选择1：是否选择今天持有，当使得持有金额最大时（即股票价格最小）
            dp[0][i] = Math.max(dp[0][i - 1], -prices[i]);
            //状态选择2：是否选择今天卖出，当获得最大价值时
            dp[1][i] = Math.max(dp[1][i - 1], prices[i] + dp[0][i - 1]);
        }
        return dp[1][n - 1];
    }

    //状态压缩——滚动数组(性能很差，因为%因素费性能也非空间)
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], -prices[i]);
            dp[1][i % 2] = Math.max(dp[1][(i - 1) % 2], prices[i] + dp[0][(i - 1) % 2]);
        }
        return dp[1][(n - 1) % 2];
    }

    //状态压缩——普通变量。是的，状态压缩后变成了"贪心"算法
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        //前一天持有股票时手上的现金（初始化最前一天的股票价格是MAX_VALUE）
        int holdCash = 0 - Integer.MAX_VALUE;
        //当天卖出股票时手上的现金
        int soldCash = 0;
        for (int i = 1; i < n; i++) {
            holdCash = Math.max(holdCash, -prices[i - 1]);
            soldCash = Math.max(soldCash, holdCash + prices[i]);
        }
        return soldCash;
    }
}
