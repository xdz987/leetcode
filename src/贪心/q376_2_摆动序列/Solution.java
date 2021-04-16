package 贪心.q376_2_摆动序列;

/**
 * 方法一：贪心
 * 局部最优：每次都为当前连续数字的最长子序列，即跳过非峰值数字
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        //比较从2个数字开始，所以总数量初始值为1
        int res = 1;
        int preDiff = 0;
        int curDiff;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            //(1)当curDiff=0，说明存在两个相等的数字，会跳过该数字
            //(2)当preDiff=0为最左侧数字连续相等的情况，之后存在峰值后preDiff永不为0
            if (preDiff <= 0 && curDiff > 0 || preDiff >= 0 && curDiff < 0) {
                preDiff = curDiff;
                res++;
            }
        }
        return res;
    }
}
