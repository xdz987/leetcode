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
        int len = nums.length;
        if (len == 0) return new int[]{};
        //(1)初始化结果res、res的索引resI、nums的索引numsI、窗口左指针(右指针可忽略)
        int[] res = new int[len - k + 1];
        int resI = 0;
        int numsI = 0;
        int winLeft = 0;
        //(1.2)初始化辅助空间。存放最大值的maxDeque双端队列
        Deque<Integer> maxDeque = new LinkedList<>();

        //(2)向填满窗口元素，并找到第一个最大值放入maxDeque
        while (numsI < k) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[numsI])
                maxDeque.pollLast();
            maxDeque.offerLast(nums[numsI]);
            numsI++;
        }
        //(3)存放第一个窗口的最大值
        res[resI++] = maxDeque.peek();

        //(4)滑动窗口
        while (numsI < len) {
            //(4.1)缩小左边窗口边界。滑动窗口左指针、maxDeque左边元素
            int removeElem = nums[winLeft++];
            if (maxDeque.peek() == removeElem) {
                maxDeque.poll();
            }

            //(4.2)扩大右边窗口边界。即滑动窗口右指针(省略)、整理maxDeque
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
