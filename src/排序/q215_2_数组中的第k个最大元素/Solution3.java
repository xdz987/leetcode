package 排序.q215_2_数组中的第k个最大元素;

import java.util.PriorityQueue;

/**
 * 固定堆-系统库
 */
public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> fixHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (fixHeap.size() > k) {
                fixHeap.poll();
                fixHeap.offer(num);
            } else {
                fixHeap.offer(num);
            }
        }
        if (fixHeap.size() > k)
            fixHeap.poll();
        return fixHeap.peek();
    }
}
