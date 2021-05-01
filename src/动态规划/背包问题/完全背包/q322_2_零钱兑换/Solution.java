package 动态规划.背包问题.完全背包.q322_2_零钱兑换;

/**
 * 方法一：备忘录DFS(性能较差)
 * 方向为自顶向下
 * Java执行：17% 12%
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        //(1)初始化备忘录。下标对应金额，不包括0
        memo = new int[amount + 1];
        //(2)DFS返回零钱搭配为最少数量硬币
        return dfs(coins, amount);
    }

    //备忘录
    int[] memo;
    public int dfs(int[] coins, int amount) {
        //(1)base case，当amount<0，说明amount不足以减去某面额硬币
        if (amount < 0) return -1;
        //零钱0返回0个硬币
        if (amount == 0) return 0;
        //(2)查找备忘录，存在直接返回
        if (memo[amount] != 0) return memo[amount];
        //需要保存最小硬币方案，res的范围可取(最大数量硬币可能,MAX_VALUE)。此题最小硬币为1元，所以res可取(amount+1,Integer.MAX_VALUE)
        int res = Integer.MAX_VALUE;
        //(3)遍历每一种面额的硬币
        for (int coin : coins) {
            //(3.1)DFS传递减去该枚硬币的金额amount - coin，并返回兑换的硬币数
            int count = dfs(coins, amount - coin);
            //(3.2)当amount-coin即不足以减去某面额硬币时触发basecase返回-1，直接跳过该种硬币可能性
            if (count == -1) continue;
            //(3.3)一个零钱数字存在多种硬币搭配方案，保存需要最少硬币的搭配方案
            res = Math.min(res, 1 + count);
        }
        //(4)保存至备忘录
        memo[amount] = res != Integer.MAX_VALUE ? res : -1;

        return memo[amount];
    }
}
