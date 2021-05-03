package 动态规划.斐波那契类型.打家劫舍类.q213_2_打家劫舍2;

/**
 * 方法一：DP
 * Java：100% 95%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
    }

    //状态压缩
    public int robRange(int[] nums, int left, int right) {
        //(1)初始化dp，初始化第一、二间的最大价值
        int[] dp = new int[nums.length];
        int ppre = nums[left];
        int pre = Math.max(nums[left], nums[left + 1]);
        int cur = pre;
        //(2)遍历所有房子，劫舍最大价值
        for (int i = left + 2; i < right; i++) {
            //状态选择：选择当前的房子与不选当前的房子中的最大值
            cur = Math.max(ppre + nums[i], pre);
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}