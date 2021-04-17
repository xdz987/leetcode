package 贪心.取差值法.q53_1_最大子序和;

/**
 * 方法二：贪心
 * Java：100% 90%
 * 最优局部："连续和"为负数时，重新定位起点
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            //动态保存当初子序列最大值
            res = Math.max(sum, res);
            //当为负数时，遇到任何正数都将拉低子序列最大值。PS：而如果nums全为负数，res会保存最大的负数
            if (sum < 0)
                sum = 0;
        }
        return res;
    }
}
