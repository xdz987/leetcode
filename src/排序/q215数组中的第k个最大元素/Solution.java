package 排序.q215数组中的第k个最大元素;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        FindKthLargest findKthLargest = new FindKthLargest();
        int res = findKthLargest.findKthLargest(nums, 2);
        System.out.println(res);
    }
}

/**
 * 随机快速排序等
 * 升序排序后返回k-1的值
 */
class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);

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