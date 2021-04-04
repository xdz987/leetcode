package 动态规划._01背包问题;

import java.util.Arrays;

/**
 * 方法一：动态规划
 */
public class Solution {
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        System.out.println(maxValue3(N, W, wt, val));
    }

    public static int maxValue(int N, int W, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int goods = 1; goods <= N; goods++) {
            for (int weight = 1; weight <= W; weight++) {
                if (weight - wt[goods - 1] < 0) {
                    dp[goods][weight] = dp[goods - 1][weight];
                } else {
                    dp[goods][weight] = Math.max(dp[goods - 1][weight - wt[goods - 1]] + val[goods - 1], dp[goods - 1][weight]);
                }
            }
        }
        return dp[N][W];
    }

    //每个重量保存最有价值的商品组合
    public static int maxValue2(int N, int W, int[] wt, int[] val) {
        //dp table，在背包重量为【第二维】时，包含前【第一维】个商品最大价值组合
        int[][] dp = new int[N + 1][W + 1];

        //外层循环/即每行，枚举每种商品
        //内存循环/即每列，枚举每种重量
        for (int goods = 1; goods <= N; goods++) {
            for (int weight = 1; weight <= W; weight++) {
                //当遍历新商品goods，背包重量为weight时，如该商品重量wt[goods-1]装不下，包含当前商品的最大价值组合和上一商品保持不变
                //goods-1是因为索引从0开始
                if (weight - wt[goods - 1] < 0) {
                    dp[goods][weight] = dp[goods - 1][weight];
                }
                //当遍历新商品goods，背包重量为weight时，如该商品重量wt[goods-1]可装下，比较【当前商品单位重量最大价值】与【截止至上一商品组合中单位重量最大价值】谁大
                //例：设当前商品重量为z，设减去重量z的最大价值组合为x，当前商品单位最大价值为y1，截止至上一商品的单位重量最大价值为y2，保存z+y1比较z+y2大中大的值
                else {
                    dp[goods][weight] = Math.max(dp[goods - 1][weight - wt[goods - 1]] + val[goods - 1], dp[goods - 1][weight]);
                }
            }
        }
        //为什么是上一个商品？因为商品的数量是唯一的，i前面的重量w已经加上了本次循环的商品了，去掉当前商品重量的w如过还再i层则为两个商品i，不符合
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[N][W];
    }

    //状态压缩
    public static int maxValue3(int N, int W, int[] wt, int[] val) {
        int[] dp = new int[W + 1];
        for (int goods = 0; goods < N; goods++) {
            for (int weight = W; weight >= 0; weight--) {
                if (weight - wt[goods] >= 0) {
                    dp[weight] = Math.max(dp[weight - wt[goods]] + val[goods], dp[weight]);
                }
            }
        }
        return dp[W];
    }
}

