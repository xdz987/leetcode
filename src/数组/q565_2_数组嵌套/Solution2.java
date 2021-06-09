package 数组.q565_2_数组嵌套;

/**
 * 方法二：快慢指针
 */
public class Solution2 {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int res = 1;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            //剪枝1：环的长度>n/2，说明环为最长的环，环以外的任意节点即使存在环，但由于与该环不交叉，所以必定不是最大长度的环
            if (res >= n / 2)
                return res;
            //剪枝2：一个环的任意节点作为起点，都不影响环的总长度，那么只需要计算一个节点为起点的该环长度即可。使用visited数组实现该思想
            if (visited[i])
                continue;
            res = Math.max(res, findCircleLength(nums, i, visited));
        }

        return res;
    }

    //通过快慢指针查找环，并计算环的长度
    private int findCircleLength(int[] nums, int i, boolean[] visited) {
        int len = 1;
        int slow = i;
        visited[i] = true;
        int fast = nums[i];
        while (slow != fast) {
            slow = nums[slow];
            visited[slow] = true;
            fast = nums[nums[fast]];
            len++;
        }
        return len;
    }
}
