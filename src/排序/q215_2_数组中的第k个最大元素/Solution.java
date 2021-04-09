package 排序.q215_2_数组中的第k个最大元素;
/**
 * 方法一：随机快速排序
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //(1)随机快排
        sort(nums, 0, nums.length - 1);
        //(2)下标从0开始则-1
        return nums[k - 1];
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            sort(nums, left, pivotIndex - 1);
            sort(nums, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >> 1);
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index - 1, pivot);
        return index - 1;
    }

    private void swap(int[] nums, int i1, int i2) {
        if (i1 == i2) {
            return;
        }
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}