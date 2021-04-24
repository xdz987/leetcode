package 图.拓扑排序.q207_2_课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 方法一：BFS+入度表
 * Java：70% 55%
 * 复杂度：O(N+M) O(N+M) 其中N和M分别为节点数量和临边数量
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        //(1)建立入度表、邻接表
        int[] inDegrees = new int[numCourses];
        //邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            //入度表
            inDegrees[pre[0]]++;
            //邻接表 单链表
            adjacency.get(pre[1]).add(pre[0]);
        }
        //(2)将入度为0的课程【下标】（没有前置课程）放入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) queue.add(i);
        }
        //(3)拓扑排序
        while (!queue.isEmpty()) {
            //(3.1)将队列中的课程del
            int pre = queue.poll();
            //(3.2)del节点后剩余总数-1
            numCourses--;
            //(3.3)并将其邻接节点入度-1
            for (int cur : adjacency.get(pre)) {
                inDegrees[cur]--;
                //(3.4)如果入度为0，则入队
                if (inDegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}