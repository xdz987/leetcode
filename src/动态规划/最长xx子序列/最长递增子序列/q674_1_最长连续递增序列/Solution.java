package 动态规划.最长xx子序列.最长递增子序列.q674_1_最长连续递增序列;

/**
 * 方法一：DP
 * Java：99% 85%
 * 复杂度：O(N) O(N)
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //(1)初始化dp、初始化边界即最小连续递增长为1
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        //(2)遍历数组
        for (int i = 1; i < n; i++) {
            //(2.1)当相邻递增时，当前元素的递增数量=前一元素的递增数量+1
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                //(3)最大的连续递增序列
                res = Math.max(res, dp[i]);
            }
            //(2.2)否则重新计数递增数量，初始化为1
            else {
                dp[i] = 1;
            }
        }
        return dp[n - 1];
    }

    //状态压缩
    public int findLengthOfLCIS2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int count = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        return res;
    }
}
