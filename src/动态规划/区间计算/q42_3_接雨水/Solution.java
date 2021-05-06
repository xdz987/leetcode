package 动态规划.区间计算.q42_3_接雨水;

/**
 * 方法一：暴力
 * Java：7% 97%
 * 复杂度：O(N^2) O(1)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        //(1)遍历水桶[1,n-2]块模板，因为只有中间的木板能盛水
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0;
            int r_max = 0;
            //(2.1)取左边最高木板或当前木板
            for (int j = 0; j <= i; j++) {
                l_max = Math.max(l_max, height[j]);
            }
            //(2.2)取右边最高木板或当前木板
            for (int j = i; j < n; j++) {
                r_max = Math.max(r_max, height[j]);
            }

            //(2.3)累加雨水。根据水桶效应，小的木板为装水的上限
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }
}