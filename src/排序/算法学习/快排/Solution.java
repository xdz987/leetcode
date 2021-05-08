package 排序.算法学习.快排;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 1, 7, 9, 8, 4};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}

class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            //移动并确定切点/中轴(由partition方法选择)
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    //分区(一半大一半小)
    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >> 1);

        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[pivot] < nums[i]) {
                //将小于pivot的数，替换到pivot的右边
                swap(nums, index, i);
                index++;
            }
        }
        //将pivot交换左半的最后一个小于pivot的数。例如「5」,3,2,「4」,6,9,8  ==> 4,3,2,「5」,6,9,8
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    //交换
    private void swap(int nums[], int i1, int i2) {
        if (i1 == i2)
            return;
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
