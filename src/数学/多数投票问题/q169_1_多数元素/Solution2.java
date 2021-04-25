package 数学.多数投票问题.q169_1_多数元素;

/**
 * 方法二：快速选择
 * Java：37% 47%
 * 复杂度：O(n) O(1) 最坏时间O(n^2)
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        return nums[nums.length / 2];
    }

    private void quickSelect(int[] nums, int left, int right, int position) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            if (partitionIndex > position) {
                quickSelect(nums, left, partitionIndex - 1, position);
            } else {
                quickSelect(nums, partitionIndex + 1, right, position);
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >>> 1);
        int index = left + 1;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, left, --index);
        return index;
    }

    private void swap(int[] nums, int i1, int i2) {
        if (i1 != i2) {
            nums[i1] ^= nums[i2];
            nums[i2] ^= nums[i1];
            nums[i1] ^= nums[i2];
        }
    }
}
