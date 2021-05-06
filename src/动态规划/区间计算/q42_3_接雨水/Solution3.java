package 动态规划.区间计算.q42_3_接雨水;

/**
 * 方法二：双指针
 */
public class Solution3 {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        //(1)初始化左右最大值为两端边界、初始双指针为两端
        int l_max = height[0];
        int r_max = height[n - 1];
        int left = 0;
        int right = n - 1;
        int res = 0;
        //(2)遍历所有木板
        while (left <= right) {
            //(2.1)取得左边最大木板
            l_max = Math.max(l_max, height[left]);
            //(2.2)取得右边最大木板
            r_max = Math.max(r_max, height[right]);
            //(2.3)根据木桶效应，按小的木板累加雨水量
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}
