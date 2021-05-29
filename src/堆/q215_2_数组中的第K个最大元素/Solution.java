package 堆.q215_2_数组中的第K个最大元素;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        FixMinHeap heap = new FixMinHeap(k + 1);
        for (int num : nums) {
            if (!heap.push(num)) {
                heap.pop();
                heap.push(num);
            }
        }
        if (heap.size > k)
            heap.pop();
        return heap.peek();
    }
}

class FixMinHeap {
    int size = 0;
    int[] queue;

    FixMinHeap(int cap) {
        queue = new int[cap + 1];
    }

    public int pop() {
        int val = queue[1];
        queue[1] = queue[size];
        queue[size] = val;
        size--;
        shiftDown(1);
        return val;
    }

    public boolean push(int val) {
        if (size == queue.length - 1) {
            return false;
        }
        size++;
        queue[size] = val;
        shiftUp(size);
        return true;
    }

    private void shiftDown(int i) {
        while ((i << 1) <= size) {
            int child = i << 1;
            if (child != size && queue[child + 1] < queue[child]) {
                child++;
            }
            if (queue[i] < queue[child]) {
                break;
            } else {
                swap(i, child);
                i = child;
            }
        }
    }

    private void shiftUp(int i) {
        while ((i >> 1) > 0) {
            int parent = i >> 1;
            if (parent > 0 && queue[i] < queue[parent]) {
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

    public int peek() {
        return queue[1];
    }

    public int size() {
        return size;
    }
}