package 其他算法.滑动窗口.q1052_2_爱生气的书店老板;

public class Solution {
    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        System.out.println(maxSatisfied.maxSatisfied(customers, grumpy, X));
    }
}

/**
 * 固定窗口
 * 重点:
 * 1. 先计算老板不生气时的满意用户量，并设customers[i]为0
 * 2. 滑动窗口求customers在x长度内的最大值
 */
class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //(1)初始化窗口指针等
        int satisfied = 0;
        int left = 0;
        int right = 0;

        //(2)计算一定满意的客户量
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
                customers[i] = 0;
            }
        }

        //滑动窗口
        int newSatisfied = 0;
        int windowSum = 0;
        while (right < customers.length) {
            int rNum = customers[right];
            right++;
            windowSum += rNum;

            //(3)窗口长度不大于X，大于时缩小窗口
            while (right - left > X) {
                int lNum = customers[left];
                left++;
                windowSum -= lNum;
            }
            //(4)计算窗口最大值
            newSatisfied = Math.max(newSatisfied, windowSum);
        }

        return satisfied + newSatisfied;
    }
}
