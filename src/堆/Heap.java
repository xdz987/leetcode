package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组实现二叉堆——大顶堆
 */
public class Heap {
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
        while ((i << 1) <= size) {
            //(1)选择左右子节点
            int child = i << 1;
            //child==size说明没有右子节点
            //大顶堆选择大的下沉
            if (child != size && queue[child + 1] > queue[child]) {
                //选择右子节点
                child++;
            }
            //(2)父节点比子节点小[大顶堆]，才有必要下沉
            if (queue[i] < queue[child]) {
                swap(i, child);
                i = child;
            } else {
                break;
            }
        }
    }

    private void shiftUp(int i) {
        //父节点至少根节点1
        while ((i >> 1) > 0) {
            int parent = i >> 1;
            //(1)只有子节点i比父节点要大才需要上浮
            if (queue[i] > queue[parent]) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int i1, int i2) {
        queue[i1] ^= queue[i2];
        queue[i2] ^= queue[i1];
        queue[i1] ^= queue[i2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 1, 7, 6, 14, 3, 56, 4};
        Heap bigHeap = new Heap(nums.length);
        for (int num : nums) {
            bigHeap.push(num);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(bigHeap.pop());
        }
    }
}
