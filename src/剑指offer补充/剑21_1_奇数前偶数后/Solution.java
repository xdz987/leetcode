package 剑指offer补充.剑21_1_奇数前偶数后;

/**
 * 方法一：双指针
 * Java：98% 83%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            if (left < right) {
                nums[left] ^= nums[right];
                nums[right] ^= nums[left];
                nums[left] ^= nums[right];
            }
        }
        return nums;
    }
}