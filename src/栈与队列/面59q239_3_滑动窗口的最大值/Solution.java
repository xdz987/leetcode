package 栈与队列.面59q239_3_滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于剑59(2)题的延续
 * 方法一：单调队列 + 单队列(可省)
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[]{};
        //(1)初始化结果res、res的索引resI、nums的索引
        int[] res = new int[len - k + 1];
        int resI = 0;
        int numsI = 0;
        //(1.2)初始化辅助空间。存放nums的队列queue单端队列，存放最大值的maxDeque双端队列
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        //(2)向填满窗口元素，并找到第一个最大值放入maxDeque
        while (numsI < k) {
            queue.offer(nums[numsI]);
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[numsI])
                maxDeque.pollLast();
            maxDeque.offerLast(nums[numsI]);
            numsI++;
        }
        //(3)存放第一个窗口的最大值
        res[resI++] = maxDeque.peek();

        //(4)滑动窗口
        while (numsI < len) {
            //(4.1)缩小左边窗口边界。即删除queue、maxDeque左边元素
            int removeElem = queue.poll();
            if (maxDeque.peek() == removeElem) {
                maxDeque.poll();
            }
            //(4.2)扩大右边窗口边界。即入队queue、整理maxDeque
            queue.offer(nums[numsI]);
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[numsI])
                maxDeque.pollLast();
            maxDeque.offerLast(nums[numsI]);
            //(4.3)指向下一个元素
            numsI++;
            //(4.4)保存当前窗口的最大值
            res[resI++] = maxDeque.peek();
        }
        return res;
    }
}
