package 排序.q215_2_数组中的第k个最大元素;

/**
 * 方法二：固定堆
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        //(1)初始化固定堆
        FixSmallHeap heap = new FixSmallHeap(k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (!heap.push(nums[i])) {
                heap.pop();
                heap.push(nums[i]);
            }
        }
        //(2)当nums.length == k时则不需要pop
        if (heap.size == k + 1)
            heap.pop();
        //(3)返回第TopK元素
        return heap.peek();
    }

    //固定小顶堆
    class FixSmallHeap {
        public int size = 0;
        int[] queue;

        FixSmallHeap(int N) {
            queue = new int[N + 1];
        }

        public boolean push(int val) {
            //超过堆的容量则返回false。PS：-1是因为元素从1开始计算
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
                if (temp < queue[parent]) {
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
                if (child != size && queue[child + 1] < queue[child])
                    child++;
                if (temp > queue[child]) {
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