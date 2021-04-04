package 动态规划.q416_2_分割等和子集;

/**
 * 方法一：DP[0-1背包]
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        //(1)计算得出目标背包容量
        int half = sum / 2;
        //(2)初始化dp table
        boolean[][] dp = new boolean[len + 1][half + 1];

        //base case，当容量为0时为满即true
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        //(3)外层循环为枚举每种商品，内层循环枚举递增背包重量
        for (int goods = 1; goods <= len; goods++) {
            for (int weight = 1; weight <= half; weight++) {
                //(3.1)背包存不下，结果等于上一商品重量结果
                if (weight - nums[goods - 1] < 0) {
                    dp[goods][weight] = dp[goods - 1][weight];
                }
                //(3.2)背包放的下，结果等于【不放的结果】【或】【当前背包重量-当前商品重量是否恰好装满】
                else {
                    dp[goods][weight] = dp[goods - 1][weight] || dp[goods - 1][weight - nums[goods - 1]];
                }
            }
        }

        return dp[len][half];
    }


    //路径压缩
    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        //(1)计算得出目标背包容量
        int half = sum / 2;
        //(2)初始化dp table
        boolean[] dp = new boolean[half + 1];

        //base case，当容量为0时为满即true
        dp[0] = true;

        //(3)外层循环为枚举每种商品，内存循环递减背包重量
        for (int goods = 0; goods < len; goods++) {
            //必须从half~0，这样dp[weight-nums[goods]]的背包重量是【上一商品】，则当前问题是基于前一子问题结果，才符合【状态转移】
            for (int weight = half; weight >= 0; weight--) {
                //(3.1)当背包容量可以放下商品时：上一商品该重量结果(保持不变)【或】放下该商品的结果(换为新商品)
                if (weight - nums[goods] >= 0) {
                    dp[weight] = dp[weight] || dp[weight - nums[goods]];
                }
            }
        }

        return dp[half];
    }
}
