package 动态规划.背包问题._01背包.q416_2_分割等和子集;

/**
 * 方法二：DP——0/1背包(自己写版)
 * Java：95% 93%
 * 复杂度：O(n^2) O(1)
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        //奇数必定无法分割两个相等的子集
        if ((target & 1) == 1)
            return false;
        target = target / 2;
        int n = nums.length;
        int[] dp = new int[target + 1];
        //(1)遍历所有商品
        for (int goods = 0; goods < n; goods++) {
            //(2)枚举每个重量
            for (int weight = target; weight >= 1; weight--) {
                int surplus = weight - nums[goods];
                //(3)背包装得下商品，才进行操作
                if (surplus >= 0) {
                    //(3.1)背包尽可能装下最大重量商品
                    dp[weight] = Math.max(dp[weight], dp[surplus] + nums[goods]);
                    //【剪枝】：判断成功立即返回，这里存在两种情况：
                    // 1. dp[weight]==target，那么在上一次访问已经返回true
                    // 2. dp[surplus]+nums[goods]==target，那么当前的if会返回true
                    if (dp[weight] == target) return true;
                }
            }
        }
        //(4)到此说明装下任意商品都
        return false;
    }
}
