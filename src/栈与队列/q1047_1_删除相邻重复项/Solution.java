package 栈与队列.q1047_1_删除相邻重复项;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 方法一：栈
 */
public class Solution {
    public String removeDuplicates(String S) {
        //(1)初始化双端队列
        int len = S.length();
        Deque<Character> stack = new LinkedList<>();
        char[] SArr = S.toCharArray();
        //(2)遍历每个字符
        for (int i = 0; i < len; i++) {
            //(2.1)相同则执行删除重复项操作，【入队处】
            if (!stack.isEmpty() && stack.peekLast() == SArr[i]) {
                stack.pollLast();
            }
            //(2.2)不相同则加入队列，【入队处】
            else {
                stack.offerLast(SArr[i]);
            }
        }
        //(3)从【出队处】出合成字符串
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.poll());
        }
        return res.toString();
    }
}