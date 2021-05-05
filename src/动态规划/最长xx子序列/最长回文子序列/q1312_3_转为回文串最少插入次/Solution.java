package 动态规划.最长xx子序列.最长回文子序列.q1312_3_转为回文串最少插入次;

/**
 * 方法一：DP
 * Java：69% 60%
 * 复杂度：O(N^2) O(N^2)
 */
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        //(1)初始化dp表、状态边界为每个子串不需要操作就是回文串，即默认为0
        int[][] dp = new int[n][n];
        //(2)由于用到第[i+1]行，所以采用自下向上遍历字符串。单字符本身不需要操作，所以从n-2开始
        for (int i = n - 1; i >= 0; i--) {
            //(3)自左到右遍历字符[i+1,n]
            for (int j = i + 1; j < n; j++) {
                //(3.1)当字符相等时，延续中间子串的插入次数
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                //(3.2)当字符不相等时，取左或右插入字符成回文串的最小操作数
                else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}