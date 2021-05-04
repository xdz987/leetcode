package 动态规划.最长xx子序列.最长公共子序列.q712_2_两字符串不同字符ascii之和;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：DP
 * Java：88% 93%
 * 复杂度：O(NM) O(NM)
 */
class Solution {
    public int minimumDeleteSum(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        //(1)初始化dp，边界为dp[0~n][0]和dp[0][0~m]均为0，即没有重复元素
        int[][] dp = new int[n + 1][m + 1];
        //(2)遍历text1（text1和text2遍历顺序没有影响）
        for (int i = 1; i <= n; i++) {
            //(3)遍历text2
            for (int j = 1; j <= m; j++) {
                //(3.1)当元素相等时，等于上一个元素的最长重复元素数量+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + (int) text1.charAt(i - 1);
                }
                //(3.2)当元素不相等时，则取A或B遍历至上一元素的最大公共子序列
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) sum += text1.charAt(i);
        for (int i = 0; i < m; i++) sum += text2.charAt(i);
        return sum - (2 * dp[n][m]);
    }
}