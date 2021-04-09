package 堆.剑40_1_最小的k个数;

import java.util.Arrays;

/**
 * 方法四：随机快排剪枝
 * java：99% 50%
 */
public class Solution4 {
    public int[] getLeastNumbers(int[] nums, int k) {
        sort(nums, 0, nums.length - 1, k);
        return Arrays.copyOfRange(nums, 0, k);
    }

    public void sort(int[] nums, int left, int right, int k) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);

            /* 与完整快排不同点，但找到分割点大于k的位置后，只需要对左边的元素进行快排*/
            if (partitionIndex >= k) {
                sort(nums, left, partitionIndex - 1, k);
            } else {
                sort(nums, partitionIndex + 1, right, k);
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        //伪随机，实为该区间的中间数
        swap(nums, left, (left + right) >> 1);

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
