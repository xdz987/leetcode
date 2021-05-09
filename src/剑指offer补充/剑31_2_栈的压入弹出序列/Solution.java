package 剑指offer补充.剑31_2_栈的压入弹出序列;

import java.util.Stack;

/**
 * 方法一：模拟
 * Java：96% 21%
 * 复杂度：O(2N) O(N)
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}