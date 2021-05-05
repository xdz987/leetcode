package 动态规划.最长xx子序列.最长公共子序列.q1035_2_不相交的线;

/**
 * 方法一：DP——LCS
 * Java：
 * 复杂度：
 */
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}