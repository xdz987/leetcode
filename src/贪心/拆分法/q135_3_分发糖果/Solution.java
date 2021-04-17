package 贪心.拆分法.q135_3_分发糖果;

import java.util.Arrays;

/**
 * 方法一：贪心
 * Java：100% 80%
 * 局部最优：
 *  1. 只要右边评分⽐左边⼤，右边的孩⼦就多⼀个糖果
 *  2. 只要左边评分⽐右边⼤，左边的孩⼦就多⼀个糖果
 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        //(1)初始化candy数组。先填充为1。提前处理了评分相等、分数小的一方的的candy
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        //(2)第一次确定从左到右中，右边评分高的candy数量
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        //(2)第二次确定从右到左中，左边评分高的candy数量
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //取max是因为第一次从左到右存在已经递增保存了candy
                //例：如[1,3,4,5,1]，5的位置左到右赋值为4，由到左为2，而正确答案为4
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        //(3)统计candy数量
        int sum = 0;
        for (int c : candy) {
            sum += c;
        }
        return sum;
    }
}