package 栈与队列.q739_2_每日温度;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 方法一：单调栈
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        //(1)初始化栈、结果res
        Deque<Integer> stack = new LinkedList<>();
        int res[] = new int[T.length];
        //(2)遍历所有元素，使用栈找到下一个高温度
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
