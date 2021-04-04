package 动态规划.q518_2_零钱兑换2;

/**
 * 方法一：DP[完全背包]
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        //(1)初始化dp table[硬币种类][金额]
        int[][] dp = new int[len + 1][amount + 1];
        //初始化当金额为0时，存在1种组合(即0元)
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        //(2)外层枚举每种硬币，内层递增金额
        for (int goods = 1; goods <= len; goods++) {
            for (int weight = 1; weight <= amount; weight++) {
                //(2.1)当背包装不下时，当前硬币的目标金额组合数等于上一硬币的目标金额组合数
                if (weight - coins[goods - 1] < 0) {
                    dp[goods][weight] = dp[goods - 1][weight];
                }
                //(2.2)当背包装的下时，当前硬币目标金额组合数 = 上一硬币的目标金额组合数 + 当前硬币的[目标金额-当前硬币额度]的目标金额组合数
                else {
                    dp[goods][weight] = dp[goods - 1][weight] + dp[goods][weight - coins[goods - 1]];
                }
            }
        }

        //(3)返回结果
        return dp[len][amount];
    }


    public int change2(int amount, int[] coins) {
        int len = coins.length;
        //(1)初始化dp table[硬币种类][金额]
        int[] dp = new int[amount + 1];
        //初始化当金额为0时，存在1种组合(即0元)
        dp[0] = 1;

        //(2)外层枚举每种硬币，内层递增金额
        for (int goods = 0; goods < len; goods++) {
            for (int weight = 0; weight <= amount; weight++) {
                //(2.1)当背包装的下时，当前硬币目标金额组合数 = 上一硬币的目标金额组合数(dp[weight]) + 当前硬币的[目标金额-当前硬币额度]的目标金额组合数(d[weight-coin[goods]])
                if (weight - coins[goods] >= 0) {
                    dp[weight] = dp[weight] + dp[weight - coins[goods]];
                }
            }
        }

        //(3)返回结果
        return dp[amount];
    }
}
