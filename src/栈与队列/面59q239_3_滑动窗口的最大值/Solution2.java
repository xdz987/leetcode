package 栈与队列.面59q239_3_滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 将方法一的单队列改为指针
 * 方法二：辅助双端队列 + 窗口指针
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[]{};
        //(1)初始化结果res、res的索引resI、nums的索引numsI、窗口左指针(右指针可忽略)
        int[] res = new int[n - k + 1];
        int resI = 0;
        //(1.2)初始化辅助空间。存放最大值的maxDeque双端队列
        Deque<Integer> maxDeque = new LinkedList<>();
        //(2)向填满窗口元素，并找到第一个最大值放入maxDeque
        for (int j = 0; j < k; j++) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[j]);
        }
        //(3)存放第一个窗口的最大值
        res[resI++] = maxDeque.peek();
        if (maxDeque.peek() == nums[0])
            maxDeque.poll();

        //(4)滑动窗口
        for (int left = 1; left <= n - k; left++) {
            int right = left + k - 1;
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            //保存当前窗口的最大值
            res[left] = maxDeque.peek();
            //当前窗口最大值为左边边界值则删除
            if (nums[left] == maxDeque.peek())
                maxDeque.poll();
        }
        return res;
    }
}
