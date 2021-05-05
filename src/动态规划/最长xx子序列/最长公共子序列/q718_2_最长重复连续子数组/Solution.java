package 动态规划.最长xx子序列.最长公共子序列.q718_2_最长重复连续子数组;

/**
 * 方法一：DP
 * Java：91% 94%
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        //(1)初始化dp，边界为dp[0~n][0]和dp[0][0~m]均为0，即没有重复元素
        int[][] dp = new int[n + 1][m + 1];
        //(2)遍历nums1（nums1和nums2遍历顺序没有影响）
        for (int i = 1; i <= n; i++) {
            //(3)遍历nums2
            for (int j = 1; j <= m; j++) {
                //(3.1)当元素相等时，等于上一个元素的最长重复元素数量+1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //(3.2)动态保存最大值
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    //状态压缩：当前元素的值只与上一和和当前行有关，逆序可压缩至一维数组
    public int findLength2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    res = Math.max(dp[j], res);
                } else
                    dp[j] = 0;
            }
        }
        return res;
    }
}