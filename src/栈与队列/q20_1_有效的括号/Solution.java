package 栈与队列.q20_1_有效的括号;

import java.util.Stack;

/**
 * 方法一：栈
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //(1)左括号则入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            //(2)说明c为右括号，栈不为空
            if (stack.isEmpty())
                return false;
            //(3)判断左右括号是否对称
            if (c == ')')
                if (stack.pop() != '(')
                    return false;
                else
                    continue;
            if (c == '}')
                if (stack.pop() != '{')
                    return false;
                else
                    continue;
            if (c == ']')
                if (stack.pop() != '[')
                    return false;
                else
                    continue;
        }
        //(4)最后栈一定为空，否则存在不成对
        return stack.isEmpty();
    }
}
