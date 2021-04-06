package 栈与队列.q503_2_下一个更大的数2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 方法一：单调栈
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //(1)初始化栈、结果res
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];

        //(2)遍历元素，数组长度*2，保存下一个更大数
        for (int i = len * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }
}
