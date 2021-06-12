package 剑指offer补充.剑60_2_n个骰子的点数;

import java.util.Arrays;

/**
 * 方法二：DP
 * Java：100% 57%
 * 复杂度：O(N^2) O(N)
 */
public class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            //筛子数2、3..时，不可能出现1、2..的点数，即i*6-(i-1)
            double[] tmp = new double[i * 6 - (i - 1)];
            for (int j = 0; j < dp.length; j++) {
                //对应每个骰子
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
