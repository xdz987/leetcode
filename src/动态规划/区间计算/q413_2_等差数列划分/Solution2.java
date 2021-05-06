package 动态规划.区间计算.q413_2_等差数列划分;

/**
 * 方法二：DP
 * Java：
 * 复杂度：
 */
public class Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        //(1)初始化dp、边界=0
        int[] dp = new int[n];
        int res = 0;
        //(2)遍历[2,n)
        for (int i = 2; i < n; i++) {
            //前后差相等说明为等差数列，更新dp
            if (nums[i - 2] - nums[i - 1] == nums[i - 1] - nums[i]) {
                dp[i] = dp[i - 1] + 1;
                //累加值
                res += dp[i];
            }
        }
        return res;
    }

    //状态压缩
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int ppre = nums[0];
        int pre = nums[1];
        int count = 0;
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (pre - ppre == nums[i] - pre) {
                count++;
                //累加值
                res += count;
            } else {
                count = 0;
            }
            ppre = pre;
            pre = nums[i];
        }
        return res;
    }
}
