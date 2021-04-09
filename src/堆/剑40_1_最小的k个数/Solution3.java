package 堆.剑40_1_最小的k个数;

import java.util.Arrays;

/**
 * 方法三：随机快排
 * 随机：68% 34%
 */
public class Solution3 {
    public int[] getLeastNumbers(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return Arrays.copyOfRange(nums, 0, k);
    }

    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            sort(nums, left, partitionIndex - 1);
            sort(nums, partitionIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        //伪随机，实为该区间的中间数
        swap(nums, left, (left + right >> 1));
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            //将大于pivot的数，替换到pivot的右边
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index++);
            }
        }
        swap(nums, index - 1, pivot);
        return index - 1;
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
