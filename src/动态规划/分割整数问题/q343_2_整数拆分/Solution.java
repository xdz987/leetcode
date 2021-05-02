package 动态规划.分割整数问题.q343_2_整数拆分;

/**
 * 方法一：DP
 * Java：64% 92%
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public int integerBreak(int n) {
        //(1)初始化dp，有效最小整数最大乘积值dp[2]=1
        int[] dp = new int[n + 1];
        dp[2] = 1;
        //(2)遍历所有整数3~n
        for (int i = 3; i <= n; i++) {
            //(3)动态保存最大乘积值
            //分割的子整数存在对称性：如3-1=2,3-2=1，1与2只需要遍历一次即可，
            int m = i / 2;
            for (int j = 1; j <= m; j++) {
                //状态选择：在【分割一次】与【分割多次(也可能是一次)】中选择乘积最大的值进行保存。如5:(1)2*3=5(2)2*2*1=4，此时分割一次为最大值
                int max = Math.max((i - j) * j, dp[i - j] * j);
                //动态保存最大值
                dp[i] = Math.max(dp[i], max);
            }
        }
        return dp[n];
    }
}