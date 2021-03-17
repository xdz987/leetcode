package 排序.算法学习.选排;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3, 4, 6, 8, 7};
        SimpleSort simpleSort = new SimpleSort();
        simpleSort.simpleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class SimpleSort {
    public void simpleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minI = i;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] < nums[minI]) {
                    minI = j;
                }
            }
            swap(nums, i, minI);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}