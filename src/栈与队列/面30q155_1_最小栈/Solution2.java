package 栈与队列.面30q155_1_最小栈;

import java.util.Stack;

/**
 * 方法二：单调栈(不使用辅助栈)
 * 重点：将min元素放在原元素之上
 */
public class Solution2 {
}

class MinStack2 {
    Stack<Integer> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(val);
            stack.push(val);
        }else {
            int min = Math.min(stack.peek(), val);
            stack.push(val);
            stack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}