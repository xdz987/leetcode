package 位运算.异或运算.自定义_亿个数中出现两次的数;

import java.util.PriorityQueue;

/**
 * 题目：有2.5亿个数，其中只有一个数出现两次，其他的数都出现一次。在内存紧张的情况下，怎么找出这个重复数？
 * 方法一：堆排序
 * 复杂度：O(NlogK) O(logK) 其中K为固定堆大小。K=3时，去掉常数为即O(N) O(1)
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 2, 3, 5, 8, 5, 0, 11, 22, 44, 555, 19, 234, 555, 6662, 224, 55215, 54409, 77, 78, 2348, 888, 33334, 4444};
        System.out.println(findRepeat(nums));
    }

    //nums.size>=3，其中两个数字相同
    public static int findRepeat(int[] nums) {
        PriorityQueue<Integer> fixHeap = new PriorityQueue<>();
        int K = 3;
        int n = nums.length;
        int mode = Integer.MIN_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (fixHeap.size() == K) {
                last = fixHeap.poll();
                fixHeap.offer(nums[i]);
                if (last == fixHeap.peek()) {
                    mode = last;
                }
            } else {
                fixHeap.offer(nums[i]);
            }
        }
        if (mode != Integer.MIN_VALUE)
            return mode;

        while (fixHeap.size() != 0) {
            if (last == fixHeap.peek()) {
                return last;
            }
            fixHeap.poll();
        }
        return -1;
    }
}
