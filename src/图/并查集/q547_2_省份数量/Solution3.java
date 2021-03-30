package 图.并查集.q547_2_省份数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 方法三：BFS（省份0递增）
 */
public class Solution3 {
    public int findCircleNum(int[][] isConnected) {
        int cityCount = isConnected.length;
        boolean[] visited = new boolean[cityCount];
        int province = 0;
        Queue<Integer> queue = new LinkedList<>();
        //(1)遍历每个城市，对每个城市进行DFS联通（设对应visited为true）
        for (int i = 0; i < cityCount; i++) {
            if (!visited[i]) {
                queue.offer(i);
                //(2)对城市进行联通
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cityCount; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                province++;
            }
        }
        return province;
    }
}
