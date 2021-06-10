package 排序.算法学习.归并;

import java.util.Arrays;

public class Test {
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
        int[] arr = new int[right - left + 1];
        int arrI = 0;
        int lI = left;
        int rI = mid + 1;
        while (lI <= mid && rI <= right) {
            if (nums[lI] < nums[rI]) {
                arr[arrI++] = nums[lI++];
            } else {
                arr[arrI++] = nums[rI++];
            }
        }
        if (lI <= mid) {
            System.arraycopy(nums, lI, arr, arrI, mid - lI + 1);
        }
        if (rI <= right) {
            System.arraycopy(nums, rI, arr, arrI, right - rI + 1);
        }
        System.arraycopy(arr, 0, nums, left, right - left + 1);
    }
}
