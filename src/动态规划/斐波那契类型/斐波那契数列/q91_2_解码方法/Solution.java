package 动态规划.斐波那契类型.斐波那契数列.q91_2_解码方法;

/**
 * 方法一：DP
 * Java：100% 76%
 * 复杂度：O(N) O(N)
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        //(1)初始化dp，初始化最小情况
        int[] dp = new int[n + 1];
        //边界条件，空字符串可以有1种解码方法，解码出1个空字符串
        dp[0] = 1;
        //(2)遍历所有2~n
        for (int i = 1; i <= n; i++) {
            //(2.1)当前数字i不为0时，说明可拆分，累加前一数字的dp值
            if (sArr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            //(2.2)前一数字i-1不为0，且前一数字与当前数字值<=26时，累加前前数字的dp值
            if (i > 1 && sArr[i - 2] != '0' && (sArr[i - 2] < '2' || sArr[i - 2] == '2' && sArr[i - 1] <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}