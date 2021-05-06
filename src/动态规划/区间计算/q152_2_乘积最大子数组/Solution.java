package 动态规划.区间计算.q152_2_乘积最大子数组;

/**
 * 方法一：DP
 * Java：88% 78%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //(1)初始化dp、初始化边界为第一个元素
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        int res = dpMax[0] = dpMin[0] = nums[0];
        //(2)遍历[1,n)
        for (int i = 1; i < n; i++) {
            //以下是最大子序和
            //dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            //(2.1)当[0,i)存在两个负数时，保存[0,i)乘积最大子数组
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            //(2.2)当[0,i)存在一个负数时，保存[0,i)乘积最小子数组
            dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
            //(2.3)保存
            res = Math.max(dpMax[i], res);
        }
        return res;
    }

    //状态压缩
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int lastMax = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], lastMax * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}