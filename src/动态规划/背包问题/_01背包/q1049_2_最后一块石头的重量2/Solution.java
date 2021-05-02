package 动态规划.背包问题._01背包.q1049_2_最后一块石头的重量2;

/**
 * 方法一：DP——0/1背包
 * Java：86% 86%
 * 复杂度：O(N*M) O(M) 其中N为石头数量，M为石头总重量/2
 */
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int goods = 1; goods <= n; goods++) {
            for (int weight = 1; weight <= target; weight++) {
                int surplus = weight - stones[goods - 1];
                //状态选择：装或不装。选择装入背包后更大重量情况
                if (surplus >= 0)
                    dp[goods][weight] = Math.max(dp[goods - 1][weight], dp[goods - 1][weight - stones[goods - 1]] + stones[goods - 1]);
                else
                    dp[goods][weight] = dp[goods - 1][weight];
            }
        }
        return sum - dp[n][target] * 2;
    }

    //状态压缩
    public int lastStoneWeightII2(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int goods = 0; goods < n; goods++) {
            for (int weight = target; weight >= 1; weight--) {
                int surplus = weight - stones[goods];
                if (surplus >= 0)
                    dp[weight] = Math.max(dp[weight], dp[weight - stones[goods]] + stones[goods]);
            }
        }
        return sum - dp[target] * 2;
    }
}