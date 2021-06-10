package 排序.算法学习.归并;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 9, 3};
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] merge = new int[right - left + 1];
        int mergeI = 0;
        int lIndex = left;
        int rIndex = mid + 1;
        while (lIndex <= mid && rIndex <= right) {
            if (nums[lIndex] < nums[rIndex]) {
                merge[mergeI++] = nums[rIndex++];
            } else {
                merge[mergeI++] = nums[lIndex++];
            }
        }
        if (lIndex <= mid) {
            System.arraycopy(nums, lIndex, merge, mergeI, mid - lIndex + 1);
        }
        if (rIndex <= right) {
            System.arraycopy(nums, rIndex, merge, mergeI, right - rIndex + 1);
        }
        System.arraycopy(merge, 0, nums, left, right - left + 1);
        System.out.println(Arrays.toString(merge));
    }
}
