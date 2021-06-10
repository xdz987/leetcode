package 排序.算法学习.冒泡;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 9, 3};
        long startTime = System.nanoTime();    //获取开始时间
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
        long endTime = System.nanoTime();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println(Arrays.toString(nums));
    }
}