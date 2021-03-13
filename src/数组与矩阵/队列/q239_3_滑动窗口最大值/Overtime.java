package 数组与矩阵.队列.q239_3_滑动窗口最大值;

import java.util.Arrays;

public class Overtime {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, 233, 2, 5, 40, 4, 3, 100, -3, 5, 1000, 6, 7};
//        int[] nums = new int[]{4, -2};
        int k = 4;
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, k)));
    }
}

/**
 * 滑动窗口暴力法：超时
 * 题目的：查找无序数组最大值的性能优化
 */
class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //(1)初始化窗口指针、res结果及指针
        int left = 0;
        int right = k - 1;
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int resIndex = 0;

        //(2)查找第一个窗口的最大值
        int windowMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            windowMax = Math.max(windowMax, nums[i]);
        }
        //滑动窗口
        while (right < length && left < length - (k - 1)) {
            windowMax = Math.max(windowMax, nums[right]);
            res[resIndex++] = windowMax;

            //(3)当最大值将移除窗口时，重新计算最大值
            if (windowMax == nums[left]) {
                windowMax = Integer.MIN_VALUE;
                for (int i = left + 1; i < right + 1; i++) {
                    windowMax = Math.max(windowMax, nums[i]);
                }
            }

            left++;
            right++;
        }

        return res;
    }
}
