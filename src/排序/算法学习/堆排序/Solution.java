package 排序.算法学习.堆排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 1, 7, 6, 14, 3, 56, 4};
        Heap bigHeap = new Heap(nums.length);
        for (int num : nums) {
            bigHeap.push(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = bigHeap.pop();
        }
        System.out.println(Arrays.toString(nums));
    }

    static class Heap {
        int size = 0;
        int[] queue;

        Heap(int N) {
            queue = new int[N + 1];
        }

        public void push(int val) {
            //如果内存不够就扩充，PS：固定堆则不用
            if (size == queue.length - 1) {
                queue = Arrays.copyOf(queue, size << 1);
            }
            queue[++size] = val;
            shiftUp(size);
        }

        public int pop() {
            int val = queue[1];
            queue[1] = queue[size];
            queue[size--] = 0;
            shiftDown(1);
            return val;
        }

        public int peek() {
            return queue[1];
        }

        private void shiftDown(int i) {
            int temp = queue[i];
            while ((i << 1) <= size) {
                //(1)选择左右子节点
                int child = i << 1;
                //child==size说明没有右子节点
                //大顶堆选择大的下沉
                if (child != size && queue[child + 1] > queue[child]) {
                    //选择右子节点
                    child++;
                }
                //(2)父节点比字节点小[大顶堆]，才有必要下沉
                if (temp < queue[child]) {
                    queue[i] = queue[child];
                    i = child;
                } else {
                    break;
                }
            }
            //(3)交换到最后，i此时为子或叶节点，直接等于父或根节点
            queue[i] = temp;
        }

        private void shiftUp(int i) {
            int temp = queue[i];
            //父节点至少根节点1
            while ((i >> 1) > 0) {
                int parent = i >> 1;
                //(1)只有子节点i比父节点要大才需要上浮
                if (temp > queue[parent]) {
                    queue[i] = queue[parent];
                    i = parent;
                } else {
                    break;
                }
            }
            //(2)交换到最后，i此时为父或根节点，直接等于子或叶节点
            queue[i] = temp;
        }
    }

}
