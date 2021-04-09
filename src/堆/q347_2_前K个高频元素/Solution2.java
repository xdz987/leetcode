package 堆.q347_2_前K个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 方法二：JDK优先队列(堆)
 * Java：70% 65%
 */
public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        //(1)统计频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        /* 与方法一的不同点，自定义【固定堆】换JDK优先队列 */
        //(2)构建【固定】【小顶堆】，元素单位为元组[频率,元素值]，插入元组
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                return n1[0] - n2[0];
            }
        }
        );
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int[] tmp = new int[]{entry.getValue(), entry.getKey()};
            if (heap.size() > k) {
                heap.poll();
            }
            heap.offer(tmp);
        }
        //(3)当heap.size == k时则不需要pop
        if (heap.size() == k + 1)
            heap.poll();

        //(4)整理数据返回
        int[] res = new int[k];
        int resI = 0;
        for (int[] num : heap) {
            res[resI++] = num[1];
        }
        return res;
    }
}
