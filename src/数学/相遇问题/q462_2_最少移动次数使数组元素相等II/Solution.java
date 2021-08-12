package 数学.相遇问题.q462_2_最少移动次数使数组元素相等II;

/**
 * 方法一：快速选择
 * Java：80% 72%
 * 复杂度：O(N) O(1) 最坏O(N^2)
 */
class Solution {
    public int minMoves2(int[] nums) {
        int median = quickSearch(nums, nums.length / 2);
        int move = 0;
        for (int num : nums) {
            move += Math.abs(median - num);
        }
        return move;
    }

    //快速查到排序后的第k个位置数字（但不完全排好序）的数字
    private int quickSearch(int[] nums, int position) {
        sort(nums, 0, nums.length - 1, position);
        return nums[position];
    }

    private void sort(int[] nums, int left, int right, int position) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            if (partitionIndex > position) {
                sort(nums, left, partitionIndex - 1, position);
            } else {
                sort(nums, partitionIndex + 1, right, position);
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >>> 1);
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, --index);
        return index;
    }

    private void swap(int[] nums, int i1, int i2) {
        if (i1 == i2) return;
        nums[i1] ^= nums[i2];
        nums[i2] ^= nums[i1];
        nums[i1] ^= nums[i2];
    }
}