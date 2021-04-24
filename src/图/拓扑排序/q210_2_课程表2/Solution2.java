package 图.拓扑排序.q210_2_课程表2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 方法一：DFS+入度表
 * Java：65% 86%
 * 复杂度：O(N+M) O(N+M)
 */
public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int resI = 0;
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                res[resI++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                inDegrees[cur]--;
                if (inDegrees[cur] == 0) {
                    queue.add(cur);
                    res[resI++] = cur;
                }
            }
        }
        return numCourses == 0 ? res : new int[]{};
    }
}
