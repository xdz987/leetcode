package 排序.算法学习.堆排序;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 9, 3};
        long startTime = System.nanoTime();    //获取开始时间
        int n = nums.length;
        BigHeap heap = new BigHeap(n);
        for(int num:nums)
            heap.push(num);
        for(int i=0;i<n;i++){
            nums[i] = heap.pop();
        }
        long endTime = System.nanoTime();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println(Arrays.toString(nums));
    }

    static class BigHeap {
        int size;
        int[] queue;

        BigHeap(int max) {
            size = 0;
            queue = new int[max + 1];
        }

        public boolean push(int x) {
            if (size == queue.length)
                return false;
            queue[++size] = x;
            shiftUp(size);
            return true;
        }

        public int pop() {
            int value = queue[1];
            queue[1] = queue[size];
            queue[size--] = 0;
            shiftDown(1);
            return value;
        }

        private void shiftUp(int i) {
            while ((i >> 1) > 0) {
                int parent = i >> 1;
                if (parent > 0 && queue[i] > queue[parent]) {
                    swap(i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        private void shiftDown(int i) {
            while ((i << 1) <= size) {
                int child = i<<1;
                if(child < size && queue[child] < queue[child+1]){
                    child++;
                }
                if(queue[child] > queue[i]) {
                    swap(child, i);
                    i = child;
                }else{
                    break;
                }
            }
        }

        private void swap(int i1, int i2) {
            int tmp = queue[i1];
            queue[i1] = queue[i2];
            queue[i2] = tmp;
        }
    }
}
