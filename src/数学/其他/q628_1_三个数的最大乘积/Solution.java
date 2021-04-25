package 数学.其他.q628_1_三个数的最大乘积;

import java.util.Arrays;

/**
 * 方法一：排序
 * Java：73% 76%
 * 复杂度：O(NlogN) O(N)排序开销
 */
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
}