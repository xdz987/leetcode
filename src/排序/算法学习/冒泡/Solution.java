package 排序.算法学习.冒泡;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 9, 3};
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean flag = true;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        System.out.println(Arrays.toString(nums));
    }
}