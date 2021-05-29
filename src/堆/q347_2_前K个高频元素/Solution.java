package 堆.q347_2_前K个高频元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：手写固定堆
 * 以元组为元素单位构建【固定】【小顶堆】
 * Java：87% 86%
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //(1)统计频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        //(2)构建【固定】【小顶堆】，元素单位为元组[频率,元素值]，插入元组
        FixSmallHeap heap = new FixSmallHeap(k + 1);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int[] tmp = new int[]{entry.getValue(), entry.getKey()};
            if (!heap.push(tmp)) {
                heap.pop();
                heap.push(tmp);
            }
        }
        //(3)当heap.size == k时则不需要pop
        if (heap.size == k + 1)
            heap.pop();

        //(4)整理数据返回
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.queue[i + 1][1];
        }
        return res;
    }

    class FixSmallHeap {
        public int size = 0;
        public int[][] queue;

        FixSmallHeap(int N) {
            queue = new int[N + 1][2];
        }

        public boolean push(int[] val) {
            if (size == queue.length - 1)
                return false;
            queue[++size] = val;
            shiftUp(size);
            return true;
        }

        public int[] pop() {
            int[] val = queue[1];
            queue[1] = queue[size];
            queue[size--] = new int[]{Integer.MAX_VALUE, 0};
            shiftDown(1);
            return val;
        }

        private void shiftUp(int i) {
            int[] tmp = queue[i];
            while ((i >> 1) > 0) {
                int parent = i >> 1;
                //子比父小则交换
                if (tmp[0] < queue[parent][0]) {
                    queue[i] = queue[parent];
                    i = parent;
                } else {
                    break;
                }
            }
            queue[i] = tmp;
        }

        private void shiftDown(int i) {
            int[] tmp = queue[i];
            while ((i << 1) <= size) {
                int child = i << 1;
                //child == size 说明没有右子节点
                if (child != size && queue[child + 1][0] < queue[child][0])
                    child++;
                //同up，子比父小则交换
                if (queue[child][0] < tmp[0]) {
                    queue[i] = queue[child];
                    i = child;
                } else {
                    break;
                }
            }
            queue[i] = tmp;
        }
    }
}