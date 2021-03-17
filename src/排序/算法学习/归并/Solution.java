package 排序.算法学习.归并;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 3, 9, 4, 7};
        MergeSort mergeSort = new MergeSort();
        nums = mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class MergeSort {
    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        if (arr.length < 2) {
            return arr;
        }
        //确定arr数组中点并进行拆分(申请内存空间)
        int mid = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        //合并所有拆分的数组
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        //对left和right数组按照小到大 合并
        int i = 0;
        while (left.length != 0 && right.length != 0) {
            if (left[0] <= right[0]) {
                res[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                res[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        //补充
        while (left.length != 0) {
            res[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length != 0) {
            res[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return res;
    }
}