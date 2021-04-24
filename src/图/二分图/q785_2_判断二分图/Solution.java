package 图.二分图.q785_2_判断二分图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 方法一：BFS+标记数组
 * Java：46% 36%
 * 复杂度：O(N+M) O(N) 其中N是无向图的顶点数，M是无向图的边数
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        //(1)初始化标记数组、队列
        int n = graph.length;
        int[] flags = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        //(2)遍历所有顶点
        for (int i = 0; i < n; i++) {
            //(2.1)已访问过则跳过
            if (flags[i] != 0) continue;
            //(2.2)将未访问过的顶点添加到队列，并染色为1
            queue.offer(i);
            flags[i] = 1;
            //(3)如果队列不为空则进行染色处理
            while (!queue.isEmpty()) {
                //(3.1)遍历出队的顶点的所有联通顶点
                int v = queue.poll();
                for (int w : graph[v]) {
                    //(3.2)如果颜色相同，不是二分图，返回false
                    if (flags[w] == flags[v])
                        return false;
                    //(3.3)颜色不相同，不做处理
                    //(3.5)顶点w未访问过，则染色为与v相反的颜色，并将顶点w添加进队列
                    if (flags[w] == 0) {
                        flags[w] = -flags[v];
                        queue.offer(w);
                    }
                }
            }
        }
        //(4)到此说明为二分图
        return true;
    }
}