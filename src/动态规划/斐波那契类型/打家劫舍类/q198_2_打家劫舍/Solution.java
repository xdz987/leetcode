package 动态规划.斐波那契类型.打家劫舍类.q198_2_打家劫舍;

/**
 * 方法一：DP
 * Java：100% 93%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        //(1)初始化dp，初始化第一、二间的最大价值
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //(2)遍历所有房子，劫舍最大价值
        for (int i = 2; i < n; i++) {
            //状态选择：选择当前的房子与不选当前的房子中的最大值
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n];
    }

    //状态压缩
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int ppre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        int cur = pre;
        for (int i = 2; i < n; i++) {
            cur = Math.max(ppre + nums[i], pre);
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}