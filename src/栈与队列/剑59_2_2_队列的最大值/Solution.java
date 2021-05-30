package 栈与队列.剑59_2_2_队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
}

/**
 * 方法一：辅助双端队列
 */
class MaxQueue {
    //原队列
    Queue<Integer> queue;
    //最大值队列
    Deque<Integer> maxDeque;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public int max_value() {
        return maxDeque.isEmpty() ? -1 : maxDeque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        //入队口进行单调栈操作
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < value)
            maxDeque.pollLast();
        maxDeque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        //原队列出队入为maxDeque最大值，则maxDeque也出队
        int val = queue.poll();
        if(val == maxDeque.peek()){
            maxDeque.poll();
        }
        return val;
    }
}