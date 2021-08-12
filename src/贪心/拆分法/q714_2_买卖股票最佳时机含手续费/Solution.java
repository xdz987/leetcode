package 贪心.拆分法.q714_2_买卖股票最佳时机含手续费;

/**
 * 方法一：贪心
 * Java：
 * 局部最优：在去除手续费的情况下卖出获得最大利润
 *  1. 去除手续费后存在利润就卖，刚好处在递增区间的顶峰，即刚好是最大利润
 *  2. 发现后面还有更高价格，后面再卖才能获得最大利润
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int n = prices.length;
        //(1)记录最小股票价格
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            //(2)动态更新当前最小股票价格
            minPrice = Math.min(minPrice, prices[i]);
            //(3)如果除去手续费还能有利润才卖，但不一定是真正卖：
            //情况一，没有卖出：后面存在更高价格的股票，这里-fee后，后续就无需再扣一次手续费
            //情况二，卖出：后面没有更高价格的股票，而出现小于minPrice的股票，minPrice被重新赋值，相等于重新开始新一轮买卖股票
            if (prices[i] - minPrice > fee) {
                //(3.1)累加利润
                res += prices[i] - minPrice - fee;
                //(3.2)更新minPrice，用于判断后面是否有更高价格，没有更高价格该minPrice会被覆盖
                minPrice = prices[i] - fee;
            }
        }
        return res;
    }
}