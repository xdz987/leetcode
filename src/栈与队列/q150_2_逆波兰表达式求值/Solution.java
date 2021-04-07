package 栈与队列.q150_2_逆波兰表达式求值;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 方法一：栈
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if (tokens[i].equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
                continue;
            }
            if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if (tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
                continue;
            }
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
