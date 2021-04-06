package 栈与队列.q225_1_用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
}

/**
 * 方法二：出栈的时候整理
 */
class MyStack2 {
    int topElem;
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        topElem = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int i = 0;
        while (i < queue.size() - 2) {
            queue.offer(queue.poll());
            i++;
        }
        topElem = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return topElem;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}