package 动态规划.背包问题._01背包.q494_2_目标和;

import java.util.Arrays;

/**
 * 方法一：DP——完全背包组合问题
 * Java：100% 94%
 * 复杂度：O(N) O(N) 其中'+''-'符号作为常数被化简
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        //S正负的组合数量相同
        S = Math.abs(S);
        //(2)计算初始化dp容量的target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum - S) % 2 == 1) return 0;
        //方式一：由target子集由S=sum-(子集*2)推导出：target=(sum-S)/2
        //方式二：也可以是target子集=子集+子集-sum=S：target=(S+sum)/2
        //但很明显(1)所需要的背包重量更小，因为S做了Math.abs(S)处理（S<=sum）
        int target = (sum - S) / 2;//注意S与target的区别：S是要求所有数字前加'+''-'的和，而target某些商品重量和。前者要求选所有商品，后者只选部分商品，所以后者有放/不放进背包的选择
        //(2)初始化dp数组，当目标即背包重量为0时，存在1种组合（无论任何数量商品）
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        //(3)外层循环遍历商品，因为商品唯一
        for (int goods = 1; goods <= n; goods++) {
            //(4)内存循环遍历背包重量
            for (int weight = 0; weight <= target; weight++) {
                if (weight >= nums[goods - 1])
                    //(4.1)更新组合数。组合数 = 上一商品的目标重量组合数 + 上一商品的[目标金额-商品重量]的目标重量组合数
                    dp[goods][weight] = dp[goods - 1][weight] + dp[goods][weight - nums[goods - 1]];
                else
                    dp[goods][weight] = dp[goods - 1][weight];
            }
        }
        return dp[n][target];
    }

    //状态压缩
    public int findTargetSumWays2(int[] nums, int S) {
        int n = nums.length;
        //S的正负数组合数量相同
        S = Math.abs(S);
        //(2)计算初始化dp容量的target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum - S) % 2 == 1) return 0;
        //方式一：target子集由S=sum-(子集*2)推导出：target=(sum-S)/2
        //方式二：target子集由S=(子集*2)-sum推导出：target=(S+sum)/2
        //但很明显(1)所需要的背包容量更小，因为S做了Math.abs(S)处理（S<=sum）
        int target = (sum - S) / 2;
        //(2)初始化dp数组，当重量为0时存在1种组合方式
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //(3)外层循环遍历商品，因为商品唯一
        for (int goods = 0; goods < n; goods++) {
            //(4)内存循环遍历背包重量
            for (int weight = target; weight >= nums[goods]; weight--) {
                //(4.1)更新组合数。组合数 = 上一商品的目标重量组合数 + 上一商品的[目标金额-商品重量]的目标重量组合数
                dp[weight] += dp[weight - nums[goods]];
            }
        }
        return dp[target];
    }
}