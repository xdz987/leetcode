package 栈与队列.面30q155_1_最小栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 方法一：单调栈(使用辅助栈)
 * 重点：使用辅助栈，该栈保存每个前n-x个值得最小值
 */
class MinStack {
    Deque<Integer> stack, minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        //使得栈顶有的比较
        minStack.push(Integer.MAX_VALUE);
    }

    //如压栈元素大于栈顶元素，则进行整理
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}