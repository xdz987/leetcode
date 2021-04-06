package 栈与队列.q496_1_下一个更大数1;

import java.util.*;

/**
 * 方法一：单调栈
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //(1)初始化
        //记录位置，记录元素及元素下一个更大数
        Map<Integer, Integer> map = new HashMap<>();
        //用于找到下一个更大数
        Deque<Integer> stack = new LinkedList<>();
        //(2)遍历nums2的每个元素，找到每个元素的下一个更大数，放入map
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        //(3)根据nums1元素的位置，将map还原成目标结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}