package 图.二分图.q886_2_可能的二分法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 方法二：BFS+标记数组（性能低）
 * Java：5% 91%
 * 复杂度：O(N+M) O(N) 其中N是无向图的顶点数，M是无向图的边数
 */
public class Solution2 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        N++;
        //(1)初始化标记表、邻接表、队列
        int[] flags = new int[N];
        List<List<Integer>> adjacency = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            //(1.1)将邻接顶点（以二分图算法的思想来看）放入邻接表
            adjacency.get(dislike[0]).add(dislike[1]);
            adjacency.get(dislike[1]).add(dislike[0]);
        }
        //(2)遍历每个顶点
        for (int i = 1; i < N; i++) {
            if (flags[i] != 0) continue;
            //(2.1)将顶点插入队列，并染色为1
            queue.offer(i);
            flags[i] = 1;
            //(2.2)队列不为空，则poll顶点v
            while (!queue.isEmpty()) {
                int v = queue.poll();
                //(2.3)将顶点v的邻接顶点相互联通
                for (int w : adjacency.get(v)) {
                    //(2.4)如果顶点v与其邻接顶点联通直接false
                    if (flags[w] == flags[v])
                        return false;
                    if (flags[w] == 0) {
                        flags[w] = -flags[v];
                        queue.offer(w);
                    }
                }
            }
        }
        return true;
    }
}
