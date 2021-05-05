package 动态规划.最长xx子序列.最长公共子序列.q392_1_判断子序列;

/**
 * 方法一：DP
 * Java：5% 5%
 * 复杂度：O(NM) O(NM)
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不同于LCS，只取以主序列为准的公共序列
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[t.length()][s.length()] == s.length();
    }
}