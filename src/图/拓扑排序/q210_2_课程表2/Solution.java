package 图.拓扑排序.q210_2_课程表2;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：DFS+标记表
 * Java：87% 23%
 * 复杂度：O(N+M) O(N+M)
 */
class Solution {
    int[] res;
    int resI;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        resI = 0;
        int[] flags = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            adjacency.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (flags[i]==0 && !dfs(adjacency, flags, i)) return new int[]{};
        }
        reverse(res);
        return res;
    }

    //反转数组
    private void reverse(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            left++;
            right--;
        }
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == -1) return true;
        if (flags[i] == 1) return false;
        flags[i] = 1;
        for (int j : adjacency.get(i)) {
            if (flags[j]!=-1 && !dfs(adjacency, flags, j)) return false;
        }
        res[resI++] = i;
        flags[i] = -1;
        return true;
    }
}
