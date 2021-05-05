package 动态规划.最长xx子序列.最长回文子序列.q647_2_回文子串的数量;

/**
 * 方法一：DP
 * Java：40% 20%
 * 复杂度：O(N^2) O(N^2)
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        //(1)初始化dp，默认全部不是回文子串即false
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        char[] sArr = s.toCharArray();
        //(2)自下向上遍历字符串，使得dp[i+1][j-1]在dp[i][j]前先计算
        for (int i = n - 1; i >= 0; i--) {
            //(2)子左向右遍历[i,n]
            for (int j = i; j < n; j++) {
                //(2.1)当字符相等时：
                /*
                    判断是否为回文串：
                    1. j=i即指向同个字符
                    2. j=i+1即为相邻字符
                    3. i到j中间的串是回文串，根据dp的含义即d[i+1][j-1]为true
                 */
                if (sArr[i] == sArr[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    //累加数量
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}