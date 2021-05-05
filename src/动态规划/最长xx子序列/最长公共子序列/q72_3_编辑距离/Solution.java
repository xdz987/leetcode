package 动态规划.最长xx子序列.最长公共子序列.q72_3_编辑距离;

/**
 * 方法一:DP
 * Java：88% 96%
 * 复杂度：O(NM) O(NM)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();
        //(1)初始化dp[][]、初始化边界编辑距离
        int dp[][] = new int[w1Len + 1][w2Len + 1];
        for (int i = 1; i <= w1Len; i++)
            dp[i][0] = i;
        for (int i = 1; i <= w2Len; i++)
            dp[0][i] = i;
        //(2)遍历word1
        for (int i = 1; i <= w1Len; i++) {
            //(3)遍历word2
            for (int j = 1; j <= w2Len; j++) {
                //(3.1)字符相等时，编辑距离不变，延续前一字符的编辑距离
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //(3.2)字符不相等时，编辑距离取增、删、改中最小的值
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[w1Len][w2Len];
    }
}