package 数学.多数投票问题.q169_1_多数元素;

/**
 * 方法一：摩尔投票法
 * Java：100% 90%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int median = 0;
        int vote = 0;
        for (int i = 0; i < n; i++) {
            if (vote == 0) {
                median = nums[i];
            }
            vote += median == nums[i] ? 1 : -1;
        }
        return median;
    }
}