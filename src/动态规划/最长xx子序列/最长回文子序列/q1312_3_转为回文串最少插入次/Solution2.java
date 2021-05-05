package 动态规划.最长xx子序列.最长回文子序列.q1312_3_转为回文串最少插入次;

/**
 * DP解法二：复杂度同解法一
 */
public class Solution2 {
    public int minInsertions(String s) {
        return s.length() - getLPS(s);
    }

    private int getLPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
