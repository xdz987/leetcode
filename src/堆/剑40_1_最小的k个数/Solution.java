package 堆.剑40_1_最小的k个数;

/**
 * 同q215思路
 * 方法一：固定堆[手写]
 * Java：68% 90%
 */
public class Solution {
    public int[] getLeastNumbers(int[] nums, int k) {
        //(1)初始化固定大顶堆
        FixBigHeap heap = new FixBigHeap(k + 1);
        for (int i = 0; i < nums.length; i++) {
            //(2)超过堆容量则pop再push
            if (!heap.push(nums[i])) {
                heap.pop();
                heap.push(nums[i]);
            }
        }
        //(3)当nums.length == k时则不需要pop
        if (heap.size == k + 1)
            heap.pop();

        //(4)将最小的k个数放入数组返回
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = heap.queue[i + 1];
        return res;
    }

    //固定小顶堆
    class FixBigHeap {
        public int size = 0;
        public int[] queue;

        FixBigHeap(int N) {
            queue = new int[N + 1];
        }

        public boolean push(int val) {
            if (size == queue.length - 1)
                return false;
            queue[++size] = val;
            shiftUp(size);
            return true;
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

        private void shiftUp(int i) {
            int temp = queue[i];
            while ((i >> 1) > 0) {
                int parent = i >> 1;
                if (temp > queue[parent]) {
                    queue[i] = queue[parent];
                    i = parent;
                } else {
                    break;
                }
            }
            queue[i] = temp;
        }

        private void shiftDown(int i) {
            int temp = queue[i];
            while ((i << 1) <= size) {
                int child = i << 1;
                if (child != size && queue[child + 1] > queue[child])
                    child++;
                if (temp < queue[child]) {
                    queue[i] = queue[child];
                    i = child;
                } else {
                    break;
                }
            }
            queue[i] = temp;
        }
    }
}