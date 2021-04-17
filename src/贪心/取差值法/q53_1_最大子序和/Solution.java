package 贪心.取差值法.q53_1_最大子序和;

/**
 * 方法一：暴力
 * Java：10% 65%
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                res = Math.max(sum,res);
            }
        }
        return res;
    }
}