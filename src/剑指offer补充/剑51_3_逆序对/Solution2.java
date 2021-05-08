package 剑指offer补充.剑51_3_逆序对;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 方法二：归并排序
 * Java：78% 47%
 * 复杂度：O(logN) O(logN)
 */
class Solution2 {
    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] merge = new int[right - left + 1];
        int mergeI = 0;
        int lIndex = left;
        int rIndex = mid + 1;
        while (lIndex <= mid && rIndex <= right) {
            if (nums[lIndex] <= nums[rIndex]) {
                merge[mergeI++] = nums[lIndex++];
            } else {
                //此为逆序对累加，其他的都是归并排序代码
                count += mid - lIndex + 1;
                merge[mergeI++] = nums[rIndex++];
            }
        }
        if (lIndex <= mid)
            System.arraycopy(nums, lIndex, merge, mergeI, mid - lIndex + 1);
        if (rIndex <= right)
            System.arraycopy(nums, rIndex, merge, mergeI, right - rIndex + 1);
        System.arraycopy(merge, 0, nums, left, right - left + 1);
    }
}