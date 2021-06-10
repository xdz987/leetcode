package 排序.算法学习.快排;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 9, 3};
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionI = partition(nums, left, right);
            quickSort(nums, left, partitionI - 1);
            quickSort(nums, partitionI + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >> 1);
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[left] > nums[i]) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index - 1, left);
        return index - 1;
    }

    private static void swap(int[] nums, int i1, int i2) {
        if (i1 == i2)
            return;
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
