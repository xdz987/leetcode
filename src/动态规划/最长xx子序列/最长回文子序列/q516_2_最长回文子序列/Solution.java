package 动态规划.最长xx子序列.最长回文子序列.q516_2_最长回文子序列;

/**
 * 方法一：DP
 * Java：72% 71%
 * 复杂度：O(NM) O(NM)
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //(1)初始化dp、初始化边界
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        //(2)遍历字符串，考虑到用到i+1行的计算结果，所以自下而上
        for (int i = n - 2; i >= 0; i--) {
            //(3)自左向右[i+1,n]，因为字符本身已经初始化为1，不需要计算，所以j=i+1
            for (int j = i + 1; j < n; j++) {
                //(3.1)两字符相等时，等于回文子串最长数+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                //(3.2)两个字符不相等时，保存两字符向内子序列中最长的数
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}