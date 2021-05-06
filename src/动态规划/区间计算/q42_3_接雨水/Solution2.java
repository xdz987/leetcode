package 动态规划.区间计算.q42_3_接雨水;

/**
 * 方法二：暴力&备忘录/动态规划
 * Java：100% 53%
 * 复杂度：O(3N) O(2N)
 */
class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        //(1)提前算好左/右木板最大值
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }

        //(2)根据木桶效应，计算雨水量
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}