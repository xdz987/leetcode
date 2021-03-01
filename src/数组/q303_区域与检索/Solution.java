package 数组.q303_区域与检索;

import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 2);
        System.out.println(param_1);
    }
}

/**
 * 重点在于实例化一次，而多次调用。
 */
class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        this.sums = nums;
        if (nums.length == 0) {
            return;
        }
        // (1)在初始化时，就将每个元素设为之前所有元素之和
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + sums[i];
        }
    }

    public int sumRange(int i, int j) {
        // (2)返回范围内的值
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}