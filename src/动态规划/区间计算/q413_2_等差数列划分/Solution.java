package 动态规划.区间计算.q413_2_等差数列划分;

/**
 * 方法一：滑动窗口
 * Java：100% 60%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        //(1)初始化窗口指针
        int res = 0;
        int left = 0;
        int right = 1;
        //(2)遍历所有元素，计算前后相邻元素之差
        int preDiff = nums[1] - nums[0];
        while (right < n - 1) {
            int curDiff = nums[right + 1] - nums[right];
            //(2.1)如前后相邻元素之差相等，则右扩窗口，并计算等差数列划分数量/连续等差数列组合数
            if (preDiff == curDiff) {
                right++;
                //计算窗口内等差数列连续组合数：如[1,2,3,4,5]的组合数是1+2+3
                if (right - left + 1 >= 3) {
                    res += right - left - 1;
                }
            }
            //(2.2)不相等则重设滑动窗口起点
            else {
                left = right++;
            }
            preDiff = curDiff;
        }
        return res;
    }
}