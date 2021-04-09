package 堆.剑40_1_最小的k个数;

import java.util.PriorityQueue;

/**
 * 方法二：jdk优先队列
 * java：20% 60%
 */
public class Solution2 {
    public int[] getLeastNumbers(int[] nums, int k) {
        //(1)初始化大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> n2 - n1
        );
        for (int i = 0; i < nums.length; i++) {
            //(2)超过堆容量则pop再push
            if (heap.size() == k + 1) {
                heap.poll();
            }
            heap.offer(nums[i]);
        }
        //(3)当nums.length == k时则不需要pop
        if (heap.size() == k + 1)
            heap.poll();

        //(4)将最小的k个数放入数组返回
        int[] res = new int[k];
        int i = 0;
        for (int num : heap) {
            res[i++] = num;
        }
        return res;
    }
}
