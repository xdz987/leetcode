package 剑指offer补充.剑45_2_将数组排成最小的数;

import java.util.Arrays;

/**
 * 方法一：按条件排序
 * Java：97% 24%
 * 复杂度：O(NlogN) O(1)
 */
class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (right + left) / 2);
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            String a = String.valueOf(nums[i]);
            String b = String.valueOf(nums[left]);
            if ((a + b).compareTo(b + a) > 0) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, left, --index);
        return index;
    }

    private void swap(int nums[], int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}